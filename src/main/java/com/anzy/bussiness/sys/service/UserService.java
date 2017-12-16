package com.anzy.bussiness.sys.service;

import com.anzy.bussiness.sys.entity.User;
import com.anzy.frame.base.service.BaseService;
import com.anzy.frame.utils.R;

import java.util.List;

/**
 * Created by anzy on 2017/12/1.
 */
public interface UserService extends BaseService<User> {
    /**
     *  Created by Vitelon on 2017-03-22
     *  根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public List<User> findByUsernameAndPwd(String username, String password);

    /**
     *  Created by Vitelon on 2017-03-30
     *  获取用户
     * @return
     */
    public List<User> find(User User);

    /**
     *  Created by Vitelon on 2017-03-30
     *  新增
     * @param User
     */
    public void add(User User);

    /**
     *  Created by Vitelon on 2017-03-30
     *  修改
     * @param User
     */
    public void update(User User);

    /**
     *  Created by Vitelon on 2017-03-30
     *  删除
     * @param id
     */
    public void delete(String id);

    public R selectUserPage(String username);
}
