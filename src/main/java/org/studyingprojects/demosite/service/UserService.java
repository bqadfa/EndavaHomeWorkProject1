package org.studyingprojects.demosite.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.studyingprojects.demosite.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

}
