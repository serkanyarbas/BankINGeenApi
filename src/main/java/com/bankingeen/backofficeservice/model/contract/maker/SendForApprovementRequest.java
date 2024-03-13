package com.bankingeen.backofficeservice.model.contract.maker;

import com.bankingeen.backofficeservice.model.contract.admin.BaseRequest;
import com.bankingeen.backofficeservice.model.dto.RecordColumnDTO;

import java.util.List;

public class SendForApprovementRequest extends BaseRequest {

    private int scenarioId;
    private List<RecordColumnDTO> oldRecords;
    private List<RecordColumnDTO> newRecords;
}
