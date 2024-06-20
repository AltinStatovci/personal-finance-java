package com.example.PersonalFinanceApi.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/health")
@CrossOrigin(origins = "*")
public class HealthController {

    @GetMapping("/ping")
    public String pingMe() {
        return "pong";
    }
}
