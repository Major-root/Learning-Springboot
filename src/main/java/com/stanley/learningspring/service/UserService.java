package com.stanley.learningspring.service;

import com.stanley.learningspring.dto.RegisterUserRequest;
import com.stanley.learningspring.dto.UserDto;
import com.stanley.learningspring.mapper.UserMapper;
import com.stanley.learningspring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserDto registerUser(RegisterUserRequest request){
        var user = userMapper.toEntity(request);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

}
