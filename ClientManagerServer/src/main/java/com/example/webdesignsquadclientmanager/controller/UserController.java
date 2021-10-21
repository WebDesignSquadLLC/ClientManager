package com.example.webdesignsquadclientmanager.controller;

import com.example.webdesignsquadclientmanager.entity.User;
import com.example.webdesignsquadclientmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {


   private final UserRepository userRepository;

   @Autowired
    public UserController (UserRepository userRepository){
       this.userRepository = userRepository;
   }

   @GetMapping(path = "/find/all")
    public @ResponseBody Iterable<User> getAllUsers(){
       return userRepository.findAll();
   }

   @GetMapping(path = "/find/id/{id}")
    public @ResponseBody User getUserById(@PathVariable Integer id){
       return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User by the id: " + id + " was not found"));
   }
    @GetMapping(path = "/find/username/{username}")
    public @ResponseBody User getUserByUsername(@PathVariable String username){
        return userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User by the username: " + username + " was not found"));
    }

    @GetMapping(path = "/find/email/{email}")
    public @ResponseBody User getUserByEmail(@PathVariable String email){
        return userRepository.findUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User by the email: " + email + " was not found"));
    }




}
