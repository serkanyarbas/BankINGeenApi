package com.bankingeen.backofficeservice.service;

import com.bankingeen.backofficeservice.jpa.BOTableRepository;
import com.bankingeen.backofficeservice.jpa.DynamicEntityRepository;
import com.bankingeen.backofficeservice.jpa.ScenarioRepository;
import com.bankingeen.backofficeservice.jpa.ScenarioTableColumnRepository;
import com.bankingeen.backofficeservice.model.contract.admin.*;
import com.bankingeen.backofficeservice.model.dto.ColumnDTO;
import com.bankingeen.backofficeservice.model.entity.BOTable;
import com.bankingeen.backofficeservice.model.entity.Scenario;
import com.bankingeen.backofficeservice.model.entity.ScenarioTableColumn;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class AdminService {


    private final BOTableRepository boTableRepository;

    private final ScenarioRepository scenarioRepository;

    private final ScenarioTableColumnRepository scenarioTableColumnRepository;

    private final DynamicEntityRepository dynamicEntityRepository;

    public AdminService(BOTableRepository boTableRepository
            , ScenarioRepository scenarioRepository
            , ScenarioTableColumnRepository scenarioTableColumnRepository
            , DynamicEntityRepository dynamicEntityRepository
    ) {
        this.boTableRepository = boTableRepository;
        this.scenarioRepository = scenarioRepository;
        this.scenarioTableColumnRepository = scenarioTableColumnRepository;
        this.dynamicEntityRepository = dynamicEntityRepository;
    }

    public ListTableResponse getTables() {

        var response = new ListTableResponse();

        var tables = boTableRepository.findAll();

        if (!CollectionUtils.isEmpty(tables)) {

            response.setTableNames(tables.stream().map(BOTable::getName).toList());
        }

        return response;
    }

    public ListTableColumnResponse getTableColumns(ListTableColumnRequest request) {

        var columnNameList = boTableRepository.findColumnNamesByTableNameOrderByOrdinalPositionAsc(request.getTableName());

        var response = new ListTableColumnResponse();
        response.setTableColumns(generateColumnDTOList(columnNameList));

        return response;
    }

    private List<ColumnDTO> generateColumnDTOList(List<String> columnList) {

        return columnList.stream()
                .map(columnName -> new ColumnDTO(columnName, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE)).toList();
    }

    public ScenarioCreateResponse scenarioCreate(ScenarioCreateRequest request) {

        var response = new ScenarioCreateResponse();

        var table = boTableRepository.findByName(request.getTableName());

        Scenario scenario = new Scenario();
        scenario.setScenarioName(request.getScenarioName());
        scenario.setTable(table);
        List<ScenarioTableColumn> scenarioTableColumns = request.getColumns().stream()
                .map(i -> new ScenarioTableColumn(table, scenario, i.columnName()
                        , i.isEditable(), i.isVisible(), i.isPrimaryKey())).toList();
        scenario.setScenarioTableColumns(scenarioTableColumns);
        scenario.setMakerRoleId(request.getMakerGroupId());
        scenario.setCheckerRoleId(request.getCheckerGroupId());

        scenarioRepository.save(scenario);
        scenarioTableColumnRepository.saveAll(scenarioTableColumns);

        return response;
    }

    public GetScenarioListResponse getScenarioList(GetScenarioListRequest request) {

        var scenarioList = scenarioRepository.findAll();

        return null;
    }
}