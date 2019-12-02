package org.studyingprojects.demosite.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SiteController {

    @GetMapping(value = "/")
    public String welcomePage() {
        return "home";
    }

    @GetMapping(value = "/login")
    public String login() {
        //log.info("User should enter credentials");
        return "login";
    }


}
