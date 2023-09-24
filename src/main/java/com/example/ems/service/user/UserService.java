package com.example.ems.service.user;

import com.example.ems.dto.UserRegistration;
import com.example.ems.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistration registration);
}
