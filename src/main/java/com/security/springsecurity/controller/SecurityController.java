package com.security.springsecurity.controller;

import com.security.springsecurity.model.ClientUser;
import com.security.springsecurity.model.Role;
import com.security.springsecurity.requestDto.RoleToUserForm;
import com.security.springsecurity.service.ClientUserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SecurityController {
    private final ClientUserServiceImp clientUserServiceImp;
    @GetMapping("/allUser")
    public ResponseEntity<List<ClientUser>> getAllUser() {
        return new ResponseEntity<>(clientUserServiceImp.getAllUser(), HttpStatus.OK);
    }
    @PostMapping("/save/user")
    public ResponseEntity<ClientUser> saveUser(@RequestBody ClientUser user){
        URI uri =URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save/user").toUriString());
        return ResponseEntity.created(uri).body(clientUserServiceImp.saveUser(user));
    }
    @PostMapping("/save/role")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri =URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save/role").toUriString());
        return ResponseEntity.created(uri).body(clientUserServiceImp.saveRole(role));
    }
    @PostMapping("/save/user/role")
    public ResponseEntity<?> addRoleToGiveUser(@RequestBody RoleToUserForm roleToUserForm){
        clientUserServiceImp.addRoleToUser(roleToUserForm.getUsername(), roleToUserForm.getRolename());
        return ResponseEntity.ok().body("Role added successfully");

    }
}
