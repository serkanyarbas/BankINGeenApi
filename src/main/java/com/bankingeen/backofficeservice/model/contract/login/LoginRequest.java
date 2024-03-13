package com.bankingeen.backofficeservice.model.contract.login;

import com.bankingeen.backofficeservice.model.contract.admin.BaseRequest;
import lombok.Getter;
import lombok.Setter;

public class LoginRequest extends BaseRequest {

    @Getter
    @Setter
    private String userCode;

    @Getter
    @Setter
    private String password;
}
