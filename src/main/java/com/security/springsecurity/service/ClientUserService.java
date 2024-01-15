package com.security.springsecurity.service;

import com.security.springsecurity.model.ClientUser;
import com.security.springsecurity.model.Role;

import java.util.List;

public interface ClientUserService {
    ClientUser saveUser(ClientUser user);
    Role saveRole(Role role);

    void addRoleToUser(String username, String rolename);

    ClientUser getUser(String username);

   // TODO Implement Pagination for below
    List<ClientUser> getAllUser();

}
