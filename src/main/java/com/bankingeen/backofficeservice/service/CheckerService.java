package com.bankingeen.backofficeservice.service;

import com.bankingeen.backofficeservice.jpa.*;
import com.bankingeen.backofficeservice.model.contract.checker.ApproveDeclineRequest;
import com.bankingeen.backofficeservice.model.contract.checker.ApproveDeclineResponse;
import com.bankingeen.backofficeservice.model.contract.checker.GetApprovementListRequest;
import com.bankingeen.backofficeservice.model.contract.checker.GetApprovementListResponse;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListRequest;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListResponse;
import com.bankingeen.backofficeservice.model.dto.ApprovementDTO;
import com.bankingeen.backofficeservice.model.dto.ScenarioDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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

    public GetApprovementListResponse getApprovementList(GetApprovementListRequest request) {

        var response = new GetApprovementListResponse();

        var user = boUserRepository.findByUserCode(request.getUserCode());

        if (user == null) {

            response.setFailureInfo("9999", "userNotFound");
            return response;
        }

        var roleId = user.getRoleId();

        var scenarioListByRoleId = scenarioRepository.findByMakerRoleId(roleId);

        List<ApprovementDTO> approvementList = new ArrayList();

        return response;
    }

    public ApproveDeclineResponse approveDecline(ApproveDeclineRequest request) {

        return null;
    }
}