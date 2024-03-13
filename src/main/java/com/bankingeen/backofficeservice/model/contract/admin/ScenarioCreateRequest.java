package com.bankingeen.backofficeservice.model.contract.admin;

import com.bankingeen.backofficeservice.model.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ScenarioCreateRequest extends BaseRequest{

    @Getter @Setter
    private String pageName;

    @Getter @Setter
    private List<Column> columns;
}
