package com.lyy.controller;

import com.alibaba.fastjson.JSONObject;
import com.lyy.domain.User;
import com.lyy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/login")
public class UserController {
    @Resource
    UserService userService;
    @ResponseBody
    @RequestMapping(value = "/loginCheck",method = RequestMethod.POST)
    public JSONObject loginCheck(String username, String password){
        JSONObject jsonObject = new JSONObject();
        String loginResult= userService.getPasswordByUsername(username,password);
        jsonObject.put("result",loginResult);
        return jsonObject;
    }
    @ResponseBody
    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public JSONObject registerUser(String username,String password,long userId,int age,
                                   String phone,String email){
        User user =new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setUserId(userId);
        user.setAge(age);
        user.setPhone(phone);
        user.setEmail(email);
        JSONObject jsonObject = new JSONObject();
        String registerResult = userService.registerUser(user);
        jsonObject.put("result",registerResult);
        return jsonObject;
    }

}
