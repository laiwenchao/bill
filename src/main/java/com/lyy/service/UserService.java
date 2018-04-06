package com.lyy.service;

import com.lyy.domain.User;

public interface UserService {
    public String getPasswordByUsername(String username,String password);
    public String registerUser(User user);
}
