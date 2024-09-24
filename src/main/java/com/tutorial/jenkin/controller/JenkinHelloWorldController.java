package com.tutorial.jenkin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinHelloWorldController {

    @GetMapping("/")
    public String landingPage()
    {
        return "landing page is called .everything is working fine";
    }
    @GetMapping("/test")
    public String welcome()
    {
        return "welcome page is called .everything is working fine";
    }
}
// http://localhost:8082/