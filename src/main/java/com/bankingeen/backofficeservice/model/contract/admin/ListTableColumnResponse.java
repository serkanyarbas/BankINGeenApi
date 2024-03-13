package com.bankingeen.backofficeservice.model.contract.admin;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ListTableColumnResponse {

    @Getter
    @Setter
    private List<String> tableColumns;
}
