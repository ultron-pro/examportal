package com.exam.examportal.controller;

import com.exam.examportal.model.Role;
import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRole;
import com.exam.examportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController
{

    @Autowired
    private UserService userService;

    @Autowired
    private   BCryptPasswordEncoder bCryptPasswordEncoder;




    //creating user
    @PostMapping("/")
    @ResponseBody
    public  User createUser(@RequestBody() User user) throws Exception
    {
        user.setProfile("default.jpg");
        //encoding password with bcrytpasswordencoder

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRole> roles=new HashSet<>();

        Role role=new Role();
        role.setRoleId(45L);
        role.setRoleName("Normal");

        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);


        roles.add(userRole);
        System.out.println(user.toString());
        return this.userService.createUser(user, roles);
    }
    @GetMapping("/{username}")
    public  User getUser(@PathVariable("username")String username)
    {

        return this.userService.getUser(username);
    }

    //delete the user by Id

    @DeleteMapping("/{userId}")
    public  void deleteUser(@PathVariable("userId") Long userId)
    {

        this.userService.deleteUser(userId);
    }


}
