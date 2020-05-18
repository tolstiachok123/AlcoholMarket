package com.am.dao;

import com.am.model.User;

import java.util.ArrayList;

public interface UserDao {

    ArrayList<User> findAllUsers();

    User findByUsername(String name);
}
