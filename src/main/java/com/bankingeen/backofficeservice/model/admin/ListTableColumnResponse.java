package com.bankingeen.backofficeservice.model.admin;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ListTableColumnResponse {

    @Getter
    @Setter
    private List<String> tableColumns;
}
