package com.security.springsecurity.service;

import com.security.springsecurity.dao.UserRepo;
import com.security.springsecurity.dtos.UserDto;
import com.security.springsecurity.model.ClientUser;
import com.security.springsecurity.model.Role;
import com.security.springsecurity.model.Roles;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.bind.support.SessionStatus;

import java.util.*;

@Service
public class AuthService {
    private UserRepo userRepository;


    public AuthService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<UserDto> login(String username, String password) {
        Optional<ClientUser> userOptional = userRepository.findClientUserByUserName(username);

        if (userOptional.isEmpty()) {
            return null;
        }

        ClientUser user = userOptional.get();

        if (!user.getPassword().equals(password)) {
            return null;
        }

        String token = RandomStringUtils.randomAlphanumeric(30);

      /*  Session session = new Session();
        session.setSessionStatus(SessionStatus.ACTIVE);
        session.setToken(token);
        session.setUser(user);
        sessionRepository.save(session);*/

        UserDto userDto = new UserDto();
        Set<Roles> roles = new HashSet<>();
        user.getRoles().forEach(x->{
            Roles role= new Roles();
            role.setRole(x.getName());
            roles.add(role);
        });
        userDto.setRoles(roles);


//        Map<String, String> headers = new HashMap<>();
//        headers.put(HttpHeaders.SET_COOKIE, token);

        MultiValueMapAdapter<String, String> headers = new MultiValueMapAdapter<>(new HashMap<>());
        headers.add(HttpHeaders.SET_COOKIE, "auth-token:" + token);



        ResponseEntity<UserDto> response = new ResponseEntity<>(userDto, headers, HttpStatus.OK);
//        response.getHeaders().add(HttpHeaders.SET_COOKIE, token);

        return response;
    }


}
