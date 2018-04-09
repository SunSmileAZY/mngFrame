package com.anzy.bussiness.sys.service.impl;

import com.anzy.bussiness.sys.dao.UserDao;
import com.anzy.bussiness.sys.entity.User;
import com.anzy.bussiness.sys.entity.qo.UserQO;
import com.anzy.bussiness.sys.service.UserService;
import com.anzy.frame.base.service.impl.BaseServiceImpl;
import com.anzy.frame.utils.R;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author anzy
 * @since 2018-03-08
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, User> implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    public R selectUserPage(String username) {
        LOGGER.info("查询任务数据：" + username);
        try {
            Page<User> page = new Page<User>(0, 2);
            this.selectPage(page);
            return R.ok().put("records", page.getRecords()).put("total", page.getTotal())
                    .put("rows", page.getSize());
        } catch (Exception e) {
            LOGGER.error("查询任务失败：" + e.getMessage());
            e.printStackTrace();
            return R.error();
        }
    }

    public User selectByAccount(String loginAccount) {
        User u = this.selectOne(new EntityWrapper<User>().eq("loginAccount", loginAccount));
        return u;
    }

    /**
     * 分页查询
     * @param userQO
     * @return
     */
    @Override
    public R listUserPage(UserQO userQO) {
        try {
            Page<User> userPage = selectPage(new Page<User>(userQO.getPage(), userQO.getRows()),  new EntityWrapper<User>()
                            .like("user_name", StringUtils.isBlank(userQO.getUsername()) ? "" : userQO.getUsername())
                            .like("user_Email", StringUtils.isBlank(userQO.getEmail())?"":userQO.getEmail())
                            .like("login_Account", StringUtils.isBlank(userQO.getLoginAccount())?"":userQO.getLoginAccount()));
            return R.ok().put("rows", userPage.getRecords()).put("total", userPage.getTotal());
        } catch (Exception e) {
            LOGGER.error("查询失败！"+e.getMessage());
        }
        return R.error();
    }


}
