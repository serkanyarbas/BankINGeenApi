package com.bankingeen.backofficeservice.model.contract.admin;

import com.bankingeen.backofficeservice.model.dto.ColumnDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ScenarioCreateRequest extends BaseRequest{

    @Getter @Setter
    private String scenarioName;

    @Getter @Setter
    private String tableName;

    @Getter @Setter
    private List<ColumnDTO> columns;

    @Getter @Setter
    private int makerGroupId;

    @Getter @Setter
    private int checkerGroupId;

}
