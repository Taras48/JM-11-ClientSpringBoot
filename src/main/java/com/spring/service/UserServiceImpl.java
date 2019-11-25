package com.spring.service;


import com.spring.model.Role;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserServiceImpl implements UserService, UserDetailsService {

    private PasswordEncoder passwordEncoder;
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserById(Long id) {
        User user = new User();
        user.setId(1l);
        user.setName("admin");
        user.setPassword("$2a$10$ziJKCTIBnsu6SELx0WsFmuiDkSiqHEz.AoVckNEHIE9Kq6Jdkvjj.");
        user.setMessage("admin");
        user.getRoles().add(new Role("admin"));
        return user;
    }

    @Override
    public void saveUser(User user) {
        restTemplate.postForObject("http://localhost:8080/admin/add", user, User.class);
        System.out.println("user save");
    }

    @Override
    public void updateUser(User user) {
        System.out.println("user update");
    }

    @Override
    public void deleteUser(Long id) {
        System.out.println("user delete");
    }

    @Override
    public List<User> findAll() {
        User user = new User();
        user.setId(1l);
        user.setName("admin");
        user.setPassword("$2a$10$ziJKCTIBnsu6SELx0WsFmuiDkSiqHEz.AoVckNEHIE9Kq6Jdkvjj.");
        user.setMessage("admin");
        user.getRoles().add(new Role("admin"));

        User user1 = new User();
        user1.setId(2l);
        user1.setName("user");
        user1.setPassword("$2a$10$ziJKCTIBnsu6SELx0WsFmuiDkSiqHEz.AoVckNEHIE9Kq6Jdkvjj.");
        user1.setMessage("user");
        user.getRoles().add(new Role("user"));
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);

       /* HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);*/

       /* ResponseEntity<User[]> responseEntity =
                restTemplate.getForEntity("http://localhost:8080/admin/all",User[].class);

        User[] users = responseEntity.getBody();

        List<User> list = Arrays.asList(users);*/

        /*User[] listUser = restTemplate.getForObject("http://localhost:8080/admin/all", User[].class);

        System.out.println(listUser.length);

        List<User> list = Arrays.asList(listUser);*/

        return list;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = new User();
        user.setId(1l);
        user.setName("admin");
        user.setPassword("$2a$10$ziJKCTIBnsu6SELx0WsFmuiDkSiqHEz.AoVckNEHIE9Kq6Jdkvjj.");
        user.setMessage("admin");
        user.getRoles().add(new Role("admin"));
        //user.setRoles(new Role("admin"));
        return user;
    }
}
