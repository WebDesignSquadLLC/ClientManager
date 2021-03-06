package com.example.webdesignsquadclientmanager.service;

import com.example.webdesignsquadclientmanager.entity.User;
import com.example.webdesignsquadclientmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public CustomeUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user =userRepository.findUserByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
                return (UserDetails) user;
    }
}
