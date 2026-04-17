package com.stanley.learningspring.mapper;

import com.stanley.learningspring.dto.RegisterUserRequest;
import com.stanley.learningspring.dto.UserDto;
import com.stanley.learningspring.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(RegisterUserRequest request);
    UserDto toDto(User user);
}


