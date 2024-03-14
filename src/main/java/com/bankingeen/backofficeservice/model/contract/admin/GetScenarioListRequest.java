package com.bankingeen.backofficeservice.model.contract.admin;

import lombok.Getter;
import lombok.Setter;

public class GetScenarioListRequest extends BaseRequest {

    @Getter @Setter
    private String userCode;
}
