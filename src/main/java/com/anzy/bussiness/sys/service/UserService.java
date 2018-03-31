package com.anzy.bussiness.sys.service;


import com.anzy.bussiness.sys.entity.User;
import com.anzy.bussiness.sys.entity.qo.UserQO;
import com.anzy.frame.base.service.BaseService;
import com.anzy.frame.utils.R;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author anzy
 * @since 2018-03-08
 */
public interface UserService extends BaseService<User> {

    R listUserPage(UserQO userQO);
}
