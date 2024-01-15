package com.security.springsecurity.service;

import com.security.springsecurity.dao.RoleRepo;
import com.security.springsecurity.dao.UserRepo;
import com.security.springsecurity.model.ClientUser;
import com.security.springsecurity.model.Role;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ClientUserServiceImp implements ClientUserService{
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    @Override
    public ClientUser saveUser(ClientUser user) {
        log.info("Saving new user {} to database", user.getUserName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        log.info("Saving new username {} with role {} to database", username, rolename);
        Optional<ClientUser> user= userRepo.findClientUserByUserName(username);
        Role role= roleRepo.findRoleByName(rolename);
        user.get().getRoles().add(role);

    }

    @Override
    public ClientUser getUser(String username) {
        log.info("Fetching existing username {} from database", username);
        return userRepo.findClientUserByName(username);
    }

    @Override
    public List<ClientUser> getAllUser() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}
