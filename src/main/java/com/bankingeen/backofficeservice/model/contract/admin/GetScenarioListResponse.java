package com.bankingeen.backofficeservice.model.contract.admin;

import com.bankingeen.backofficeservice.model.dto.ScenarioDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class GetScenarioListResponse extends BaseResponse {

    @Getter @Setter
    private List<ScenarioDTO> scenarioList;
}
