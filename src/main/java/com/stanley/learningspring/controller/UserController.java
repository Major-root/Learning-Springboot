package com.stanley.learningspring.controller;

import com.stanley.learningspring.dto.RegisterUserRequest;
import com.stanley.learningspring.dto.UserDto;
import com.stanley.learningspring.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    public ResponseEntity<?> registerUser (
            @Valid @RequestBody RegisterUserRequest request,
            UriComponentsBuilder uriComponentsBuilder
            ){
        var response = userService.registerUser(request);
        var uri = uriComponentsBuilder.path("/user/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
