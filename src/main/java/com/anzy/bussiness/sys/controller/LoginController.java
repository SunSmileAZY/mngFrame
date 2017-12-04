package com.anzy.bussiness.sys.controller;

import com.anzy.frame.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by anzy on 2017/12/4.
 */
@Controller
@RequestMapping("/login/")
public class LoginController {

    @RequestMapping("login")
    public R login(String username,String pwd,String vCode){

        return R.error();
    }



}
