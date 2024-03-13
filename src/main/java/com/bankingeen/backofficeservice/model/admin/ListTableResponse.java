package com.bankingeen.backofficeservice.model.admin;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ListTableResponse {

    @Getter
    @Setter
    private List<String> tableNames;
}
