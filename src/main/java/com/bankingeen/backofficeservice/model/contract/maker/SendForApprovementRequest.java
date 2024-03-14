package com.bankingeen.backofficeservice.model.contract.maker;

import com.bankingeen.backofficeservice.model.contract.admin.BaseRequest;
import com.bankingeen.backofficeservice.model.dto.RecordColumnDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SendForApprovementRequest extends BaseRequest {

    @Getter @Setter
    private int scenarioId;

    @Getter @Setter
    private List<RecordColumnDTO> oldContent;

    @Getter @Setter
    private List<RecordColumnDTO> newContent;

    @Getter @Setter
    private int makerUserId;
}
