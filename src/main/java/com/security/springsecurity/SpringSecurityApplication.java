package com.security.springsecurity;

import com.security.springsecurity.model.ClientUser;
import com.security.springsecurity.model.Role;
import com.security.springsecurity.service.AuthService;
import com.security.springsecurity.service.ClientUserServiceImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner run(AuthService authService) {
        return args -> {
            authService.login("Raza","12345");
            /*
            clientUserServiceImp.saveRole(new Role(null,"ROLE_ADMIN"));
            clientUserServiceImp.saveRole(new Role(null,"ROLE_USER"));
            clientUserServiceImp.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
            clientUserServiceImp.saveRole(new Role(null,"ROLE_MANAGER"));

            clientUserServiceImp.saveUser(new ClientUser(1L, "Raza Mustafa", "Raza", "12345", new ArrayList<>()));
            clientUserServiceImp.saveUser(new ClientUser(null, "Raman raghav", "Raman", "78901", new ArrayList<>()));
            clientUserServiceImp.saveUser(new ClientUser(null, "Raghi pandit", "Raghi", "00000", new ArrayList<>()));
            clientUserServiceImp.saveUser(new ClientUser(null, "Pujit dua", "Pujit", "77777", new ArrayList<>()));
            clientUserServiceImp.saveUser(new ClientUser(null, "Ankit kumar", "Ankit", "45678", new ArrayList<>()));

            clientUserServiceImp.addRoleToUser("Raza","ROLE_SUPER_ADMIN");
            clientUserServiceImp.addRoleToUser("Raza","ROLE_USER");
            clientUserServiceImp.addRoleToUser("Raghi","ROLE_ADMIN");
            clientUserServiceImp.addRoleToUser("Pujit","ROLE_MANAGER");
            clientUserServiceImp.addRoleToUser("Ankit","ROLE_USER");
            clientUserServiceImp.addRoleToUser("Raza","ROLE_MANAGER");*/

            System.out.println("args running..");



        };
    }
}
