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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        /*User user = new User();
        user.setId(1l);
        user.setName("admin");
        user.setPassword("$2a$10$ziJKCTIBnsu6SELx0WsFmuiDkSiqHEz.AoVckNEHIE9Kq6Jdkvjj.");
        user.setMessage("admin");
        user.getRoles().add(new Role("admin"));
        //user.setRoles(new Role("admin"));*/
        User user = restTemplate.getForObject("http://localhost:8080/admin/" + s, User.class);
        return user;
    }
}
