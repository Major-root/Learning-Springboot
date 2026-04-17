package com.stanley.learningspring.dto;

import com.stanley.learningspring.entity.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class RegisterUserRequest {
    @NotBlank(message = "FirstName is required")
    @Size(max = 255, message = "FirstName must be less than 255 Characters")
    private String firstName;

    @NotBlank(message = "Provide your password")
    @Size(min = 6, message = "The minimum password length is 6")
    private String password;


    @NotBlank(message = "Email is required")
    @Email(message = "Provide a valid email address")
    private String email;

    private String lastName;

    @NotBlank(message = "Provide your fucking role mate")
    @Size(max = 100, message = "You self, provide role with max of 100 char")
    private Roles roles;
}
