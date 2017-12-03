package com.anzy.bussiness.sys.service.impl;

import com.anzy.bussiness.sys.dao.UserDao;
import com.anzy.bussiness.sys.entity.User;
import com.anzy.bussiness.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anzy on 2017/12/1.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public User findByUsernameAndPwd(String name, String pwd) {

        return userDao.findByUsernameAndPwd(name, pwd);
    }

    public List<User> find(User user){

        return userDao.find(user);
    }


    public void add(User user) {

        userDao.add(user);
    }

    public void update(User user) {

        userDao.update(user);
    }

    public void delete(String id) {

        userDao.delete(id);
    }
}
