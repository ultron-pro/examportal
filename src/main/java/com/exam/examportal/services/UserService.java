package com.exam.examportal.services;

import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRole;

import java.util.Set;

public interface UserService {

    //creating user;

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(String username);

    public  void deleteUser(Long userId);


}
