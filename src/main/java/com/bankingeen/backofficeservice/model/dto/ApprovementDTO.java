package com.bankingeen.backofficeservice.model.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

public record ApprovementDTO(
        List<RecordColumnDTO> oldContent

        ,List<RecordColumnDTO> newContent

        ,int makerUserId

        ,int checkerUserId

        ,String status) {
}
