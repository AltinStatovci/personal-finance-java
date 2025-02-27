package com.example.PersonalFinanceApi.auth.controller;

import com.example.PersonalFinanceApi.auth.authModel.AuthenticationRequest;
import com.example.PersonalFinanceApi.auth.authModel.AuthenticationResponse;
import com.example.PersonalFinanceApi.auth.authModel.RegisterRequest;
import com.example.PersonalFinanceApi.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}