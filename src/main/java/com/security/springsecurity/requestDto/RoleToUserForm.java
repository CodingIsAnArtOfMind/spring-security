package com.security.springsecurity.requestDto;

import lombok.Data;

@Data
public class RoleToUserForm {
    private String username;
    private String rolename;
}
