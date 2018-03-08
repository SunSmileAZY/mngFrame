package com.anzy.bussiness.sys.controller;

import com.anzy.bussiness.sys.entity.User;
import com.anzy.bussiness.sys.service.UserService;
import com.anzy.frame.base.controller.AbstractController;
import com.anzy.frame.utils.R;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by anzy on 2017/12/1.
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController{

    @Resource
    private UserService userService;

    @RequiresRoles("admin")
    @RequestMapping("/init")
    public String index(HttpServletRequest request){
        logger.info("request.getSession().getId():"+request.getSession().getId());
        return "sys/user";
    }

}