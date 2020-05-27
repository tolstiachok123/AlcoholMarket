package com.am.dao.impl;

import com.am.dao.RoleDao;
import com.am.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String USER_QUERY_ROLES = "SELECT userId, name FROM users " +
            "LEFT OUTER JOIN users_roles " +
            "ON users.userId = users_roles.users_userId " +
            "LEFT OUTER JOIN roles " +
            "ON users_roles.role_roleId = roles.roleId WHERE user.userId = ?";

    @Override
    public List<Role> findAllRoles(Integer userId) {
        return jdbcTemplate.query(USER_QUERY_ROLES, new RoleMapper(), userId);
    }

}
