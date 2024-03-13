package com.bankingeen.backofficeservice.model.dto;

public record ScenarioDTO(
        int scenarioId
        ,String scenarioName
        ,String tableName
        , String filterQuery
) {
}