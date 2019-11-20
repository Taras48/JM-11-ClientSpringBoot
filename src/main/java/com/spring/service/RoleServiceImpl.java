package com.spring.service;

import com.spring.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {

    @Override
    public Role findAllByRole(String role) {
        return new Role(role);
    }

}
