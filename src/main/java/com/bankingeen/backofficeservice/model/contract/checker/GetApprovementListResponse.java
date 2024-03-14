package com.bankingeen.backofficeservice.model.contract.checker;

import com.bankingeen.backofficeservice.model.dto.ApprovementDTO;
import com.bankingeen.backofficeservice.model.contract.admin.BaseResponse;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class GetApprovementListResponse extends BaseResponse {

    @Getter @Setter
    private List<ApprovementDTO> approvementList;
}
