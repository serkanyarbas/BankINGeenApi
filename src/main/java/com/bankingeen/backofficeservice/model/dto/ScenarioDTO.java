package com.bankingeen.backofficeservice.model.dto;

public record ScenarioDTO(
        Long scenarioId
        ,String scenarioName
        ,String tableName
        , String filterQuery
) {
}