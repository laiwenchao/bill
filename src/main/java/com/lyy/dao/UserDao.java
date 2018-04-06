package com.lyy.dao;

import com.lyy.domain.User;

public interface UserDao {
    public User getPasswordByUsername(String username);
    public int registerUser(User user);
}
