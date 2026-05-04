package com.stanley.learningspring.service;

import com.stanley.learningspring.dto.RegisterUserRequest;
import com.stanley.learningspring.dto.UserDto;
import com.stanley.learningspring.exceptions.DuplicateUserException;
import com.stanley.learningspring.mapper.UserMapper;
import com.stanley.learningspring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDto registerUser(RegisterUserRequest request){
        if (userRepository.existsByEmail(request.getEmail())){
            System.out.println("Hey dwag, some duplicate entry mate");
            throw new DuplicateUserException();
        };
        var user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

}
