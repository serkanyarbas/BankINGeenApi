package com.bankingeen.backofficeservice.service;

import com.bankingeen.backofficeservice.jpa.*;
import com.bankingeen.backofficeservice.model.contract.checker.ApproveDeclineRequest;
import com.bankingeen.backofficeservice.model.contract.checker.ApproveDeclineResponse;
import com.bankingeen.backofficeservice.model.contract.checker.GetApprovementListRequest;
import com.bankingeen.backofficeservice.model.contract.checker.GetApprovementListResponse;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListRequest;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListResponse;
import com.bankingeen.backofficeservice.model.dto.ScenarioDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

    public GetApprovementListResponse getApprovementList(GetApprovementListRequest request) {

        return null;
    }

    public ApproveDeclineResponse approveDecline(ApproveDeclineRequest request) {

        return null;
    }
}