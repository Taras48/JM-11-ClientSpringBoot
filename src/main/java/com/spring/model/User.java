package com.spring.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class User implements UserDetails {


    private Long id;
    private String name;
    private String password;
    private String message;


    private Set<Role> roles = new HashSet<Role>();

    public User() {
    }

    public User(String name, String password, String message, Set<Role> roles) {
        this.name = name;
        this.password = password;
        this.message = message;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

  /*  public void setRoles(String role) {
        roles.add(new Role(role));
    }*/

    public void setRoles(Role role) {
        roles.add(role);
    }

    public Set<Role> getRoles() {
        return roles;
    }

   /* public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }*/
}
