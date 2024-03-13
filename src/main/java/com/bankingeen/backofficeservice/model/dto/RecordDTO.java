package com.bankingeen.backofficeservice.model.dto;

import java.util.List;

public record RecordDTO(
        List<RecordColumnDTO> columns
) {
}