package org.studyingprojects.demosite.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.studyingprojects.demosite.domain.dto.UserDTO;
import org.studyingprojects.demosite.domain.model.User;
import org.studyingprojects.demosite.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/register")
@RequiredArgsConstructor
@Slf4j
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @GetMapping
    public String registerForm() {return "registration";}

    @PostMapping
    public String processRegistration(@Valid UserDTO form, Errors errors) {
        if (errors.hasErrors()){
            return "registration";
        }
        User save = (User) userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
