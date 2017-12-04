package com.anzy.bussiness.sys.controller;

import com.anzy.bussiness.sys.entity.User;
import com.anzy.bussiness.sys.service.UserService;
import com.anzy.frame.base.controller.AbstractController;
import com.anzy.frame.utils.R;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
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

    @RequestMapping("/index")
    public String index(){

        return "index";
    }

    @RequestMapping("/find")
    @ResponseBody
    public R find(User user, HttpServletRequest request){

        try {
            logger.info("你已通过springMVC进入controller方法。。。。");
            List<User> loginuser = userService.findByUsernameAndPwd(user.getUsername(),user.getLoginPwd());
            return R.ok().put("data",loginuser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error();
    }


    @ResponseBody
    @RequestMapping("/listUser")
    public R listUser(String username){
        logger.info("获取用户列表。。。。");
        try {
            return userService.selectUserPage(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error();
    }

}