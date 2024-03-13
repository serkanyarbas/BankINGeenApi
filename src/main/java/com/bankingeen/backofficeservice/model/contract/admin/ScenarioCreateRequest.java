package com.bankingeen.backofficeservice.model.contract.admin;

import com.bankingeen.backofficeservice.model.contract.common.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ScenarioCreateRequest extends BaseRequest{

    @Getter @Setter
    private String scenarioName;

    @Getter @Setter
    private String tableName;

    @Getter @Setter
    private List<Column> columns;

    @Getter @Setter
    private int makerGroupId;

    @Getter @Setter
    private int checkerGroupId;

}
