package com.spring.service;


import com.spring.model.Role;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService, UserDetailsService {

    private PasswordEncoder passwordEncoder;

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
        user.setRoles(new Role("admin"));
        return user;
    }

    @Override
    public void saveUser(User user) {
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
        user.setRoles(new Role("admin"));

        User user1 = new User();
        user1.setId(2l);
        user1.setName("user");
        user1.setPassword("$2a$10$ziJKCTIBnsu6SELx0WsFmuiDkSiqHEz.AoVckNEHIE9Kq6Jdkvjj.");
        user1.setMessage("user");
        user1.setRoles(new Role("user"));
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);

        return list;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = new User();
        user.setId(1l);
        user.setName("admin");
        user.setPassword("$2a$10$ziJKCTIBnsu6SELx0WsFmuiDkSiqHEz.AoVckNEHIE9Kq6Jdkvjj.");
        user.setMessage("admin");
        user.setRoles(new Role("user"));
        return user;
    }
}
