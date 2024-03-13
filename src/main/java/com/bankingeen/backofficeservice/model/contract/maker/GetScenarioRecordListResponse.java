package com.bankingeen.backofficeservice.model.contract.maker;

import com.bankingeen.backofficeservice.model.contract.admin.BaseResponse;
import com.bankingeen.backofficeservice.model.dto.ColumnDTO;
import com.bankingeen.backofficeservice.model.dto.ScenarioRecordDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class GetScenarioRecordListResponse extends BaseResponse {

    @Getter @Setter
    private List<ScenarioRecordDTO> scenarioRecordList;
    @Getter @Setter
    private List<ColumnDTO> columnMeta;
}