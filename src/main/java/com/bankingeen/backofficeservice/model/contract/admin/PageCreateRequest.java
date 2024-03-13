package com.bankingeen.backofficeservice.model.contract.admin;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PageCreateRequest {

    @Getter
    @Setter
    private String pageName;

    @Getter
    @Setter
    private List<String> primaryKeyColumns;

    @Getter
    @Setter
    private List<String> visibleColumns;

    @Getter
    @Setter
    private List<String> editableColumns;
}
