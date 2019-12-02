package org.studyingprojects.demosite.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.studyingprojects.demosite.repository.UserRepository;

import static java.util.Collections.singletonList;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;

    //@Autowired
    //public UserDetailServiceImpl(UserRepository userRepository) {
    //  this.userRepository = userRepository;
    //}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User '" + username + "'(lol, is this really your username?) not found."));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                singletonList(user.getRole()));
    }


}
