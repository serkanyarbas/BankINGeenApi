package com.bankingeen.backofficeservice.model.contract.maker;

import com.bankingeen.backofficeservice.model.contract.admin.BaseRequest;
import lombok.Getter;
import lombok.Setter;

public class GetScenarioListRequest extends BaseRequest {

    @Getter @Setter
    private String userCode;
}
