package com.caihua.controller;

import com.alibaba.fastjson.JSON;
import com.caihua.bean.Classes;
import com.caihua.bean.User;
import com.caihua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("translate")
    public String translate() {
        userService.addToRedis();
        return "redirect:success.jsp";
    }

    @RequestMapping(value = "addUsers",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String add(){
        userService.addUser();
        return JSON.toJSONString("添加成功");
    }

}
