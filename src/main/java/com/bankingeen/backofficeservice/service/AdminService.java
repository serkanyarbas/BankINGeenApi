package com.bankingeen.backofficeservice.service;

import com.bankingeen.backofficeservice.jpa.BOTableRepository;
import com.bankingeen.backofficeservice.jpa.ScenarioRepository;
import com.bankingeen.backofficeservice.jpa.ScenarioTableColumnRepository;
import com.bankingeen.backofficeservice.model.contract.admin.*;
import com.bankingeen.backofficeservice.model.entity.BOTable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class AdminService {


    private final BOTableRepository boTableRepository;

    private final ScenarioRepository scenarioRepository;

    private final ScenarioTableColumnRepository scenarioTableColumnRepository;

    public AdminService(BOTableRepository boTableRepository
    ,ScenarioRepository scenarioRepository
    ,ScenarioTableColumnRepository scenarioTableColumnRepository
    ){
        this.boTableRepository = boTableRepository;
        this.scenarioRepository = scenarioRepository;
        this.scenarioTableColumnRepository = scenarioTableColumnRepository;
    }

    public ListTableResponse getTables(ListTableRequest listTableRequest) {

        var response = new ListTableResponse();

        var tables = boTableRepository.findAll();

        if (!CollectionUtils.isEmpty(tables)) {

            response.setTableNames(tables.stream().map(BOTable::getName).toList());
        }

        return response;
    }

    public ListTableColumnResponse getTableColumns(ListTableColumnRequest listTableColumnRequest) {

        return null;
    }

    public ScenarioCreateResponse pageCreate(ScenarioCreateRequest pageCreateRequest) {

        return null;
    }
}
