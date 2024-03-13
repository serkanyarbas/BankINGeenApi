package com.bankingeen.backofficeservice.service;

import com.bankingeen.backofficeservice.jpa.*;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListRequest;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListResponse;
import org.springframework.stereotype.Service;

@Service
public class CheckerService {

    private final BOUserRepository boUserRepository;

    private final ScenarioRepository scenarioRepository;

    private final ApprovementRepository approvementRepository;

    public CheckerService(BOUserRepository boUserRepository
            , ScenarioRepository scenarioRepository
            , ApprovementRepository approvementRepository
    ) {
        this.boUserRepository = boUserRepository;
        this.scenarioRepository = scenarioRepository;
        this.approvementRepository = approvementRepository;
    }

    public GetScenarioListResponse getScenarioList(GetScenarioListRequest request) {

        //var userRoleId = boUserRepository.findRoleIdByUserCode(request.userCode)
  //var scenarios = scenarioRepository.getScenariosByCheckerRoleId(userRoleId);
        return null;
    }


}