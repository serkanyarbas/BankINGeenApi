package com.bankingeen.backofficeservice.service;

import com.bankingeen.backofficeservice.jpa.BOTableRepository;
import com.bankingeen.backofficeservice.jpa.ScenarioRepository;
import com.bankingeen.backofficeservice.jpa.ScenarioTableColumnRepository;
import com.bankingeen.backofficeservice.model.contract.admin.*;
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

    public AdminService(BOTableRepository boTableRepository
            , ScenarioRepository scenarioRepository
            , ScenarioTableColumnRepository scenarioTableColumnRepository
    ) {
        this.boTableRepository = boTableRepository;
        this.scenarioRepository = scenarioRepository;
        this.scenarioTableColumnRepository = scenarioTableColumnRepository;
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

        return null;
    }

    public ScenarioCreateResponse scenarioCreate(ScenarioCreateRequest request) {

        var response = new ScenarioCreateResponse();

        var table = boTableRepository.findByName(request.getTableName());

        Scenario scenario = new Scenario();
        scenario.setScenarioName(request.getScenarioName());
        scenario.setTable(table);
        List<ScenarioTableColumn> scenarioTableColumns = request.getColumns().stream()
                .map(i -> new ScenarioTableColumn(table, scenario, i.getColumnName()
                        , i.isEditable(), i.isVisible(), i.isPrimaryKey())).toList();
        scenario.setScenarioTableColumns(scenarioTableColumns);

        scenarioRepository.save(scenario);

        return response;
    }
}