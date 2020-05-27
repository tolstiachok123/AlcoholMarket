package com.am.dao;

import com.am.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> findAllRoles(Integer userId);
}
