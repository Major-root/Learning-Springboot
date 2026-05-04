package com.stanley.learningspring.dto;

import com.stanley.learningspring.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Roles role;
}
