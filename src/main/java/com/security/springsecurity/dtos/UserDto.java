package com.security.springsecurity.dtos;

import com.security.springsecurity.model.Roles;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDto {
    private String email;
    private Set<Roles> roles = new HashSet<>();

}
