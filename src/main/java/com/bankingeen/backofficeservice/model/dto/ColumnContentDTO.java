package com.bankingeen.backofficeservice.model.dto;

public record ColumnContentDTO(
        String columnName,
        String columnValue,
        String type
) {
}