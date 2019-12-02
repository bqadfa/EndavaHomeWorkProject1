package org.studyingprojects.demosite.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.studyingprojects.demosite.domain.dto.UserDTO;

@RestController
public class UserController {

    @GetMapping(value = "/user")
    public UserDTO user() { return new UserDTO(); }
}
