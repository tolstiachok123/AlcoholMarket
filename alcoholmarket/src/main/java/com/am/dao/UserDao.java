package com.am.dao;

import com.am.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAllUsers();

    User findByUsername(String name);

    void addUser(User user);
}
