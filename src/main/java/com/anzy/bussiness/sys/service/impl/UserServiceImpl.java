package com.anzy.bussiness.sys.service.impl;

import com.anzy.bussiness.sys.dao.UserDao;
import com.anzy.bussiness.sys.entity.User;
import com.anzy.bussiness.sys.service.UserService;
import com.anzy.frame.base.service.impl.BaseServiceImpl;
import com.anzy.frame.utils.R;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anzy on 2017/12/1.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao,User> implements UserService{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    public List<User> findByUsernameAndPwd(String name, String pwd) {

        return baseMapper.findByUsernameAndPwd(name, pwd);
    }

    public List<User> find(User user){

        return baseMapper.find(user);
    }


    public void add(User user) {

        baseMapper.add(user);
    }

    public void update(User user) {

        baseMapper.update(user);
    }

    public void delete(String id) {

        baseMapper.delete(id);
    }
    public R selectUserPage(String username) {
        LOGGER.info("查询任务数据：" + username);
        try {
            Page<User> page = new Page<User>(0, 2);
            this.selectPage(page);
            return R.ok().put("records", page.getRecords()).put("total", page.getTotal())
                    .put("rows", page.getSize());
        }
        catch (Exception e) {
            LOGGER.error("查询任务失败：" + e.getMessage());
            e.printStackTrace();
            return R.error();
        }
    }

}
