package com.bankingeen.backofficeservice.service;

import com.bankingeen.backofficeservice.jpa.*;
import com.bankingeen.backofficeservice.model.contract.maker.SendForApprovementRequest;
import com.bankingeen.backofficeservice.model.contract.maker.SendForApprovementResponse;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioRecordListRequest;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioRecordListResponse;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListRequest;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListResponse;
import com.bankingeen.backofficeservice.model.dto.ColumnContentDTO;
import com.bankingeen.backofficeservice.model.dto.ColumnDTO;
import com.bankingeen.backofficeservice.model.dto.ScenarioDTO;
import com.bankingeen.backofficeservice.model.dto.ScenarioRecordDTO;
import com.bankingeen.backofficeservice.model.entity.Approvement;
import com.bankingeen.backofficeservice.model.entity.Scenario;
import com.bankingeen.backofficeservice.model.entity.ScenarioTableColumn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class MakerService {

    private BOUserRepository boUserRepository;
    private ScenarioRepository scenarioRepository;
    private ScenarioTableColumnRepository scenarioTableColumnRepository;
    private ApprovementRepository approvementRepository;

    private DynamicEntityRepository dynamicEntityRepository;

    private BOTableRepository boTableRepository;

    public MakerService(BOUserRepository boUserRepository
            , ScenarioRepository scenarioRepository
            , ScenarioTableColumnRepository scenarioTableColumnRepository
            , ApprovementRepository approvementRepository
            , DynamicEntityRepository dynamicEntityRepository
            , BOTableRepository boTableRepository
    ) {

        this.boUserRepository = boUserRepository;
        this.scenarioRepository = scenarioRepository;
        this.scenarioTableColumnRepository = scenarioTableColumnRepository;
        this.approvementRepository = approvementRepository;
        this.dynamicEntityRepository = dynamicEntityRepository;
        this.boTableRepository = boTableRepository;
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

            var scenarioDTOList = scenarioListByRoleId.stream().map(i -> new ScenarioDTO(i.getId(), i.getScenarioName()
                    , i.getTable().getName(), i.getFilterQuery())).toList();

            response.setScenarioList(scenarioDTOList);
        }

        return response;
    }

    public GetScenarioRecordListResponse getScenarioRecordList(GetScenarioRecordListRequest request) {

        var response = new GetScenarioRecordListResponse();

        var scenarioOptional = scenarioRepository.findById(request.getScenarioId());

        if (scenarioOptional.isEmpty())
            return response;

        var scenario = scenarioOptional.get();

        var columnDTOList = generateScenarioColumnMetaData(scenario.getScenarioTableColumns());
        response.setColumnMeta(columnDTOList);

        List<ScenarioRecordDTO> scenarioRecordDTOS = generateScenarioRecordDTOs(scenario);
        response.setScenarioRecordList(scenarioRecordDTOS);

        return response;
    }

    private List<ScenarioRecordDTO> generateScenarioRecordDTOs(Scenario scenario) {

        var tableName = scenario.getTable().getName();
        var schema = scenario.getTable().getSchema();

        var dynamicDataList = dynamicEntityRepository.getDynamicTableData(tableName, schema);
        var tableColumnNameList = boTableRepository.findColumnNamesByTableNameOrderByOrdinalPositionAsc(tableName);

        List<ScenarioRecordDTO> scenarioRecordDTOS = new ArrayList<>();

        for (int i = 0; i < dynamicDataList.size(); i++) {

            var dynamicData = dynamicDataList.get(i);

            List<ColumnContentDTO> columnContentList = getColumnContentList(dynamicData, tableColumnNameList);

            ScenarioRecordDTO recordDTO = new ScenarioRecordDTO(columnContentList);
            scenarioRecordDTOS.add(recordDTO);
        }
        return scenarioRecordDTOS;
    }

    private static List<ColumnContentDTO> getColumnContentList(Object[] dynamicData, List<String> tableColumnNameList) {

        List<ColumnContentDTO> columnContentList = new ArrayList<>();

        for (int j = 0; j < tableColumnNameList.size(); j++) {

            var columnValue = dynamicData[j];
            var columnName = tableColumnNameList.get(j);
            ColumnContentDTO columnContentDTO = new ColumnContentDTO(columnName, columnValue.toString(), "varchar");
            columnContentList.add(columnContentDTO);
        }
        return columnContentList;
    }

    private List<ColumnDTO> generateScenarioColumnMetaData(List<ScenarioTableColumn> scenarioTableColumnList) {

        return scenarioTableColumnList
                .stream()
                //.filter(ScenarioTableColumn::isVisible)
                .map(stc -> new ColumnDTO(stc.getColumnName(), stc.isPrimaryKey(), stc.isEditable(), true)).toList();

    }

    public SendForApprovementResponse sendForApprovement(SendForApprovementRequest request) {

        var response = new SendForApprovementResponse();

        Approvement entity = new Approvement();
        entity.setScenarioId(request.getScenarioId());
        entity.setMakerUserId(request.getMakerUserId());
        entity.setStatus("Pending");

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            entity.setNewContent(objectMapper.writeValueAsString(request.getNewContent()));
            entity.setOldContent(objectMapper.writeValueAsString(request.getOldContent()));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        approvementRepository.save(entity);


        return response;
    }
}