package com.spring.controler;

import com.spring.model.JsonUser;
import com.spring.model.User;
import com.spring.service.RoleService;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserRestController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/all")
    public @ResponseBody
    List<User> getAllUsers() {
        List<User> list = userService.findAll();
        return list;
    }

    @PostMapping(value = "/add")
    public void postAdd(@RequestBody JsonUser jsonUser) {
        User user = new User();
        user.setName(jsonUser.getName());
        user.setPassword(jsonUser.getPassword());
        user.getRoles().add(roleService.findAllByRole(jsonUser.getRole()));
        user.setMessage(jsonUser.getMessage());
        userService.saveUser(user);
    }

    @PutMapping(value = "/update")
    public void putUpdateUser(@RequestBody JsonUser jsonUser) {
      //  User upUser = userService.getUserById(jsonUser.getId());
        User upUser = new User();
        upUser.setId(jsonUser.getId());
        upUser.setName(jsonUser.getName());
        upUser.setPassword(jsonUser.getPassword());
        upUser.getRoles().add(roleService.findAllByRole(jsonUser.getRole()));
        upUser.setMessage(jsonUser.getMessage());
        userService.updateUser(upUser);
    }

    @DeleteMapping(value = "/delete")
    public void deleteUser(@RequestBody Long id) {
        userService.deleteUser(id);
    }

    @PostMapping
    public UserService deleteUser() {
        User user =(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (UserService)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
