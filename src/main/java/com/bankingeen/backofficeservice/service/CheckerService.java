package com.bankingeen.backofficeservice.service;

import com.bankingeen.backofficeservice.jpa.*;
import com.bankingeen.backofficeservice.model.contract.checker.ApproveDeclineRequest;
import com.bankingeen.backofficeservice.model.contract.checker.ApproveDeclineResponse;
import com.bankingeen.backofficeservice.model.contract.checker.GetApprovementListRequest;
import com.bankingeen.backofficeservice.model.contract.checker.GetApprovementListResponse;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListRequest;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListResponse;
import com.bankingeen.backofficeservice.model.dto.ApprovementDTO;
import com.bankingeen.backofficeservice.model.dto.ColumnDTO;
import com.bankingeen.backofficeservice.model.dto.RecordColumnDTO;
import com.bankingeen.backofficeservice.model.dto.ScenarioDTO;
import com.bankingeen.backofficeservice.model.entity.Approvement;
import com.bankingeen.backofficeservice.model.entity.ScenarioTableColumn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckerService {

    private final BOUserRepository boUserRepository;

    private final ScenarioRepository scenarioRepository;

    private ScenarioTableColumnRepository scenarioTableColumnRepository;

    private final ApprovementRepository approvementRepository;

    public CheckerService(BOUserRepository boUserRepository
            , ScenarioRepository scenarioRepository
            , ScenarioTableColumnRepository scenarioTableColumnRepository
            , ApprovementRepository approvementRepository
    ) {
        this.boUserRepository = boUserRepository;
        this.scenarioRepository = scenarioRepository;
        this.scenarioTableColumnRepository = scenarioTableColumnRepository;
        this.approvementRepository = approvementRepository;
    }

    public GetApprovementListResponse getApprovementList(GetApprovementListRequest request) {

        var response = new GetApprovementListResponse();

        var user = boUserRepository.findByUserCode(request.getUserCode());

        if (user == null) {

            response.setFailureInfo("9999", "userNotFound");
            return response;
        }

        var roleId = user.getRoleId();

        var scenarioListByRoleId = scenarioRepository.findByCheckerRoleId(roleId);

        List<ApprovementDTO> approvementList = new ArrayList();

        for(var scenario: scenarioListByRoleId){
            List<Approvement> approvements = approvementRepository.findByScenarioIdAndStatus(scenario.getId(),"Pending");
            var columnDTOList = generateScenarioColumnMetaData(scenario.getScenarioTableColumns());
            List<ApprovementDTO> approvementDTOByScenario = approvements.stream()
                    .map(i -> new ApprovementDTO(i.getId(), toContent(i.getOldContent()), toContent(i.getNewContent())
                            , i.getMakerUserId(),i.getCheckerUserId(),i.getStatus(),columnDTOList)).toList();
            approvementList.addAll(approvementDTOByScenario);
        }
        response.setApprovementList(approvementList);

        return response;
    }

    private List<RecordColumnDTO> toContent(String content) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(content, new TypeReference<List<RecordColumnDTO>>(){});

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public ApproveDeclineResponse approveDecline(ApproveDeclineRequest request) {

        var response = new ApproveDeclineResponse();

        var approvementOpt = approvementRepository.findById(request.getApprovementId());

        if (approvementOpt.isEmpty()) {
            response.setFailureInfo("9999", "userNotFound");
            return response;
        }

        var approvement = approvementOpt.get();
        approvement.setStatus(request.isApproved() ? "Approved" : "Denied");
        approvement.setCheckerUserId(request.getCheckerUserId());

        approvementRepository.save(approvement);

        if (request.isApproved()) {

            updateContent(approvement.getScenarioId(), approvement.getNewContent());
        }

        return response;
    }

    private void updateContent(int scenarioId, String newContent) {

        var scenarioOpt = scenarioRepository.findById((long) scenarioId);
        var scenario = scenarioOpt.get();
        var scenarioTableColumns = scenario.getScenarioTableColumns();

        ObjectMapper mapper = new ObjectMapper();

        try {
            List<RecordColumnDTO> newRecord = mapper.readValue(newContent, new TypeReference<List<RecordColumnDTO>>(){});
            executeQuery(scenarioTableColumns, newRecord);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void executeQuery(List<ScenarioTableColumn> scenarioTableColumns, List<RecordColumnDTO> newRecord) {

        // TODO : yapılacak.
    }

    private List<ColumnDTO> generateScenarioColumnMetaData(List<ScenarioTableColumn> scenarioTableColumnList) {

        return scenarioTableColumnList
                .stream()
                .filter(ScenarioTableColumn::isVisible)
                .map(stc -> new ColumnDTO(stc.getColumnName(), stc.isPrimaryKey(), stc.isEditable(), true)).toList();

    }
}