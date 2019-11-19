package com.spring.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;


public class Role implements GrantedAuthority {


    private Long id;
    private String role;

    private Set<User> user = new HashSet<User>();

    public Role() {
    }

    public Role(String role, Set<User> user) {
        this.role = role;
        this.user = user;
    }

    public Role(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return role;
    }

    @Override
    public String getAuthority() {
        return this.role;
    }
}
