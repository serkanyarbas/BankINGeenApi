package com.bankingeen.backofficeservice.service;

import com.bankingeen.backofficeservice.jpa.ApprovementRepository;
import com.bankingeen.backofficeservice.jpa.BOUserRepository;
import com.bankingeen.backofficeservice.jpa.ScenarioRepository;
import com.bankingeen.backofficeservice.jpa.ScenarioTableColumnRepository;
import com.bankingeen.backofficeservice.model.contract.maker.SendForApprovementRequest;
import com.bankingeen.backofficeservice.model.contract.maker.SendForApprovementResponse;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioRecordListRequest;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioRecordListResponse;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListRequest;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListResponse;
import com.bankingeen.backofficeservice.model.dto.ScenarioDTO;
import com.bankingeen.backofficeservice.model.entity.Approvement;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.dialect.JsonHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

@Service
public class MakerService {

    private BOUserRepository boUserRepository;
    private ScenarioRepository scenarioRepository;
    private ScenarioTableColumnRepository scenarioTableColumnRepository;

    private ApprovementRepository approvementRepository;

    public MakerService(BOUserRepository boUserRepository
            , ScenarioRepository scenarioRepository
            , ScenarioTableColumnRepository scenarioTableColumnRepository
            , ApprovementRepository approvementRepository
    ) {

        this.boUserRepository = boUserRepository;
        this.scenarioRepository = scenarioRepository;
        this.scenarioTableColumnRepository = scenarioTableColumnRepository;
        this.approvementRepository = approvementRepository;
    }

    public GetScenarioListResponse getScenarioList(GetScenarioListRequest request) {

        var response = new GetScenarioListResponse();

        var user = boUserRepository.findByUserCode(request.getUserCode());

        if (user == null) {

            response.setFailureInfo("9999", "userNotFound");
            return response;
        }

        var roleId = user.getRoleId();

        var scenarioListByRoleId = scenarioRepository.findByMakerRoleId(roleId);

        if (!CollectionUtils.isEmpty(scenarioListByRoleId)) {

            scenarioListByRoleId.stream().map(i -> new ScenarioDTO(i.getId(),i.getScenarioName()
                    ,i.getTable().getName(),i.getFilterQuery()));

        }

        return response;
    }

    public GetScenarioRecordListResponse getScenarioRecordList(GetScenarioRecordListRequest request) {

        var response = new GetScenarioRecordListResponse();

        return response;
    }

    public SendForApprovementResponse sendForApprovement(SendForApprovementRequest request) {

        var response = new SendForApprovementResponse();

        Approvement entity = new Approvement();
        entity.setScenarioId(request.getScenarioId());
        entity.setMakerUserId(request.getMakerUserId());

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            entity.setNewContent(objectMapper.writeValueAsString(request.getNewRecords()));
            entity.setOldContent(objectMapper.writeValueAsString(request.getOldRecords()));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        approvementRepository.save(entity);

        return response;
    }
}