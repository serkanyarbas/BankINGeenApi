package com.bankingeen.backofficeservice.service;

import com.bankingeen.backofficeservice.jpa.BOTableRepository;
import com.bankingeen.backofficeservice.jpa.ScenarioRepository;
import com.bankingeen.backofficeservice.jpa.ScenarioTableColumnRepository;
import com.bankingeen.backofficeservice.model.contract.admin.*;
import org.springframework.stereotype.Service;

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


        return null;
    }

    public ListTableColumnResponse getTableColumns(ListTableColumnRequest listTableColumnRequest) {

        return null;
    }

    public ScenarioCreateResponse pageCreate(ScenarioCreateRequest pageCreateRequest) {

        return null;
    }
}
