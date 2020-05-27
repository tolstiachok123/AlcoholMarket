package com.am.dao.impl;

import com.am.dao.UserDao;
import com.am.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final String getAllUsersQuery = "SELECT * FROM users";
    private final String getUserByNameQuery = "SELECT * FROM users WHERE name = ?";
    private final String addUser = "INSERT INTO users(name, surname, mail, phone, password) VALUES (?, ?, ?, ?, ?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAllUsers() {
        List<User> users = (ArrayList<User>) jdbcTemplate.query(getAllUsersQuery, new UserMapper());
        return users;
    }

    @Override
    public User findByUsername(String name) {
        User user = (User) jdbcTemplate.query(getUserByNameQuery, new UserMapper(), name);
        return user;
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update(addUser, user.getName(), user.getSurname(), user.getMail(), user.getPhone(), passwordEncoder.encode(user.getPassword()));
        Integer id = jdbcTemplate.queryForObject("SELECT id FROM users WHERE name = ?", Integer.class, user.getName());
        jdbcTemplate.update("INSERT INTO users_roles(roles_roleId, users_userId) VALUES (?, ?)", 2, id);
    }
}
