package com.bankingeen.backofficeservice.model.contract.login;

import com.bankingeen.backofficeservice.model.contract.admin.BaseResponse;
import lombok.Getter;
import lombok.Setter;

public class LoginResponse extends BaseResponse {

    @Getter
    @Setter
    private int roleId;

    @Getter
    @Setter
    private String userId;
}
