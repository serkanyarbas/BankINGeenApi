package com.bankingeen.backofficeservice.model.dto;

import java.io.Serializable;

public record RecordColumnDTO(
        String columnName,
        String columnValue
) implements Serializable {
}