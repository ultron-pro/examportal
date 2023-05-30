package com.exam.examportal.services.impl;

import com.exam.examportal.helper.UserNotFoundException;
import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRole;
import com.exam.examportal.repo.RoleRepository;
import com.exam.examportal.repo.UserRepository;
import com.exam.examportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServicesImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local=this.userRepository.findByUsername(user.getUsername());

        if(local != null)
        {
            System.out.println("user is already there !!");
            throw  new UserNotFoundException();

        }
        else
        {

            // user create ...

            for (UserRole ur:userRoles)
            {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }
   // get user name by username
    @Override
    public User getUser(String username) {


        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }


}
