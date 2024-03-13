package com.bankingeen.backofficeservice.service;

import com.bankingeen.backofficeservice.jpa.BOTableRepository;
import com.bankingeen.backofficeservice.jpa.ScenarioRepository;
import com.bankingeen.backofficeservice.jpa.ScenarioTableColumnRepository;
import com.bankingeen.backofficeservice.model.contract.admin.*;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListRequest;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListResponse;
import com.bankingeen.backofficeservice.model.entity.BOTable;
import com.bankingeen.backofficeservice.model.entity.Scenario;
import com.bankingeen.backofficeservice.model.entity.ScenarioTableColumn;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class MakerService {

    public GetScenarioListResponse getScenarioList(GetScenarioListRequest request) {

        return null;
    }
}