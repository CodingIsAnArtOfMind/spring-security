package com.security.springsecurity.dao;

import com.security.springsecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findRoleByName(String name);
}
