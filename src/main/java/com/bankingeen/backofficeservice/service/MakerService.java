package com.bankingeen.backofficeservice.service;

import com.bankingeen.backofficeservice.jpa.BOUserRepository;
import com.bankingeen.backofficeservice.jpa.ScenarioRepository;
import com.bankingeen.backofficeservice.jpa.ScenarioTableColumnRepository;
import com.bankingeen.backofficeservice.model.contract.maker.SendForApprovementRequest;
import com.bankingeen.backofficeservice.model.contract.maker.SendForApprovementResponse;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioRecordListRequest;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioRecordListResponse;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListRequest;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListResponse;
import org.springframework.stereotype.Service;

@Service
public class MakerService {

    private BOUserRepository boUserRepository;
    private ScenarioRepository scenarioRepository;
    private ScenarioTableColumnRepository scenarioTableColumnRepository;

    public MakerService(BOUserRepository boUserRepository, ScenarioRepository scenarioRepository, ScenarioTableColumnRepository scenarioTableColumnRepository) {

        this.boUserRepository = boUserRepository;
        this.scenarioRepository = scenarioRepository;
        this.scenarioTableColumnRepository = scenarioTableColumnRepository;
    }

    public GetScenarioListResponse getScenarioList(GetScenarioListRequest request) {

        var response = new GetScenarioListResponse();

        return response;
    }

    public GetScenarioRecordListResponse getScenarioRecordList(GetScenarioRecordListRequest request) {

        var response = new GetScenarioRecordListResponse();

        return response;
    }

    public SendForApprovementResponse sendForApprovement(SendForApprovementRequest request) {

        var response = new SendForApprovementResponse();

        return response;
    }
}