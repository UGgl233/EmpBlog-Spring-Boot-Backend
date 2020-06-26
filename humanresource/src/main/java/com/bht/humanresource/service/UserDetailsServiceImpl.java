package com.bht.humanresource.service;

import com.bht.humanresource.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.bht.humanresource.model.User user = userRepository.getUserByEmail(s);
        User.UserBuilder builder = null;
        if(user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(user.getEmail());
            //builder.username(user.getEmail());
            builder.password(user.getPassword());
            String[] roles = {user.getRole()}; //create a new user role array
            builder.roles(roles);
        }else {
            throw new UsernameNotFoundException("username not found");
        }
        return builder.build();
    }

    //register new user
    public void saveUser(com.bht.humanresource.model.User u){
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        userRepository.saveUser(u);
    }
}
