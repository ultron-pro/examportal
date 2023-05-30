package com.exam.examportal.controller;

import com.exam.examportal.config.JwtUtil;
import com.exam.examportal.helper.UserNotFoundException;
import com.exam.examportal.model.JwtRequest;
import com.exam.examportal.model.JwtResponse;
import com.exam.examportal.model.User;
import com.exam.examportal.services.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager  authenticationManager;

    @Autowired
    private UserDetailsImpl userDetails;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        try {

            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }
        catch (UserNotFoundException e)
        {
            e.printStackTrace();
            throw new Exception("User not Found");
        }
        //authenticate serverces
        UserDetails userDetails= this.userDetails.loadUserByUsername(jwtRequest.getUsername());
        String token= this.jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));

    }


    private void authenticate(String username,String password) throws Exception {
        try
        {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }
        catch (DisabledException e)
        {

            throw  new Exception("user Disabled"+e.getMessage());
        }
        catch (BadCredentialsException e)
        {
            throw  new Exception("INVALID CREDENTIALS"+e.getMessage());

        }

    }
    // Return of current user who is login user
    @GetMapping("/current-user")
    public  User getCurrentUser(Principal principal)
    {

        return ((User) this.userDetails.loadUserByUsername(principal.getName()));

    }
}
