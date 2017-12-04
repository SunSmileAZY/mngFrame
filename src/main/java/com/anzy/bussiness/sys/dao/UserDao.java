package com.anzy.bussiness.sys.dao;

import com.anzy.bussiness.sys.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by anzy on 2017/12/1.
 */
public interface UserDao extends BaseMapper<User>{

    /**
     *  Created by Vitelon on 2017-03-22
     *  根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public List<User> findByUsernameAndPwd(@Param("username") String username, @Param("password") String password);

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
}