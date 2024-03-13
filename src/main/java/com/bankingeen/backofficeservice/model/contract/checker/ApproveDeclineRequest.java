package com.bankingeen.backofficeservice.model.contract.checker;

import com.bankingeen.backofficeservice.model.contract.admin.BaseRequest;
import lombok.Getter;
import lombok.Setter;

public class ApproveDeclineRequest extends BaseRequest {

    @Getter @Setter
    private String approvementId;

    @Getter @Setter
    private boolean isApproved;
}
