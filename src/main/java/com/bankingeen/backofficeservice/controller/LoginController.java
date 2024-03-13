package com.bankingeen.backofficeservice.controller;

import com.bankingeen.backofficeservice.model.contract.login.LoginRequest;
import com.bankingeen.backofficeservice.model.contract.login.LoginResponse;
import com.bankingeen.backofficeservice.service.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/v1")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {

        return loginService.login(loginRequest);
    }
}
