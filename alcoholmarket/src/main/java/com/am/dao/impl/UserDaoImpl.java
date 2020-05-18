package com.am.dao.impl;

import com.am.dao.UserDao;
import com.am.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

public class UserDaoImpl implements UserDao {

    private final String getAllUsersQuery = "SELECT * FROM users";
    private final String getUserByNameQuery = "SELECT * FROM users WHERE name = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArrayList<User> findAllUsers() {
        ArrayList<User> users = (ArrayList<User>) jdbcTemplate.query(getAllUsersQuery, new UserMapper());
        return users;
    }

    @Override
    public User findByUsername(String name) {
        User user = (User) jdbcTemplate.query(getUserByNameQuery, new UserMapper(), name);
        return user;
    }
}
