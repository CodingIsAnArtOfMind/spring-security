package com.security.springsecurity.dao;

import com.security.springsecurity.model.ClientUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<ClientUser,Long> {
    ClientUser findClientUserByName(String name);
    Optional<ClientUser> findClientUserByUserName(String username);
}
