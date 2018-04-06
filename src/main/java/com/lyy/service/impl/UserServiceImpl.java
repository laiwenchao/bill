package com.lyy.service.impl;

import com.lyy.dao.UserDao;
import com.lyy.domain.User;
import com.lyy.service.UserService;
import com.lyy.utils.Md5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    UserDao userDao;
    public String getPasswordByUsername(String username, String password) {
        User user= userDao.getPasswordByUsername(username);
        String md5Password = Md5Utils.md5Password(password);
        if(md5Password.equals(user.getPassword())){
            return "success";
        }
        return "failed";
    }

    public String registerUser(User user) {
        String registerusername =user.getUsername();
        User userExist = userDao.getPasswordByUsername(registerusername);
        if(userExist.getPassword()==null){
            userDao.registerUser(user);
        }
        return "user has aleady registered";
    }
}
