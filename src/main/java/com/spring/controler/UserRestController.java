package com.spring.controler;

import com.spring.dto.UserDto;
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
    public void postAdd(@RequestBody UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.getRoles().add(roleService.findAllByRole(userDto.getRole()));
        user.setMessage(userDto.getMessage());
        userService.saveUser(user);
    }

    @PutMapping(value = "/update")
    public void putUpdateUser(@RequestBody UserDto userDto) {
      //  User upUser = userService.getUserById(userDto.getId());
        User upUser = new User();
        upUser.setId(userDto.getId());
        upUser.setName(userDto.getName());
        upUser.setPassword(userDto.getPassword());
        upUser.getRoles().add(roleService.findAllByRole(userDto.getRole()));
        upUser.setMessage(userDto.getMessage());
        userService.updateUser(upUser);
    }

    @DeleteMapping(value = "/delete")
    public void deleteUser(@RequestBody Long id) {
        userService.deleteUser(id);
    }

    @PostMapping
    public String getUserPage() {
        String roles = "not";
        User user =(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getRoles().size() > 1){
            roles = "all";
        }
        return roles;
    }
}
