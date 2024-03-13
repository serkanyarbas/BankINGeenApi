package com.bankingeen.backofficeservice.model.dto;



public record ColumnDTO(
        String columnName,
        Boolean isPrimaryKey,

        Boolean isEditable,

        Boolean isVisible
) {
}
