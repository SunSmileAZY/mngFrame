package com.anzy.bussiness.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by anzy on 2018/1/24.
 */
@Controller
@RequestMapping("/sms/")
public class SmsController {

    @RequestMapping("init")
    public String init(){
        return "sms/sms";
    }





}
