package com.spring.service;


import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class UserServiceImpl implements UserService, UserDetailsService {

    private PasswordEncoder passwordEncoder;
    private RestTemplate restTemplate;


    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, RestTemplate restTemplate) {
        this.passwordEncoder = passwordEncoder;
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userName = new User();
        userName.setName(s);
        return restTemplate.postForObject("http://localhost:8080/admin/"+s, userName, User.class);
    }

    @Override
    public User getUserById(Long id) {
        User user = restTemplate.getForObject("http://localhost:8080/admin/" + id, User.class);
        return user;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        restTemplate.postForEntity("http://localhost:8080/admin/add", user, User.class);
        System.out.println("user save");
    }

    @Override
    public void updateUser(User user) {
        restTemplate.put("http://localhost:8080/admin/update", user, User.class);
        System.out.println("user update");
    }

    @Override
    public void deleteUser(Long id) {
        restTemplate.delete("http://localhost:8080/admin/delete/" + id);
        System.out.println("user delete");
    }

    @Override
    public List<User> findAll() {
        User[] listUser = restTemplate.getForObject("http://localhost:8080/admin/all", User[].class);
        System.out.println(listUser.length);
        List<User> list = Arrays.asList(listUser);
        return list;
    }

}
