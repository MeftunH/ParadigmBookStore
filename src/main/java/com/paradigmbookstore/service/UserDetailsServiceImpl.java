package com.paradigmbookstore.service;

import com.paradigmbookstore.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;
import java.util.stream.Stream;


public class UserDetailsServiceImpl implements UserDetailsService
{
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);
        var roles = Stream.of(user.getRole())
                .map(obj->new SimpleGrantedAuthority(obj.name())).toList();
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                                                                      user.getPassword(),
                                                                      roles);
    }
}
