package com.bankingeen.backofficeservice.service;

import com.bankingeen.backofficeservice.jpa.BOUserRepository;
import com.bankingeen.backofficeservice.model.contract.login.LoginRequest;
import com.bankingeen.backofficeservice.model.contract.login.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final BOUserRepository boUserRepository;

    public LoginService(BOUserRepository boUserRepository) {
        this.boUserRepository = boUserRepository;
    }

    public LoginResponse login(LoginRequest loginRequest) {

        var response = new LoginResponse();
        var userOpt = boUserRepository.findByUserCodeAndUserPassEncrypt(loginRequest.getUserCode(), loginRequest.getPassword());

        if (userOpt.isEmpty()) {
            response.setFailureInfo("55", "Invalid user or password");
            return response;
        }

        response.setRoleId(userOpt.get().getRoleId());

        return response;
    }
}
