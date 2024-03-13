package com.bankingeen.backofficeservice.model.contract.common;

import lombok.Getter;
import lombok.Setter;

public class Column {

    @Getter @Setter
    private String columnName;

    @Getter @Setter
    private boolean isPrimaryKey;

    @Getter @Setter
    private boolean isEditable;

    @Getter @Setter
    private boolean isVisible;
}
