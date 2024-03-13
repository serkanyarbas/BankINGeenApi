package com.bankingeen.backofficeservice.model.dto;


public record ApprovementDTO(String oldContent,
                             String newContent,
                             int makerUserId,
                             int checkerUserId,
                             String status) {



}
