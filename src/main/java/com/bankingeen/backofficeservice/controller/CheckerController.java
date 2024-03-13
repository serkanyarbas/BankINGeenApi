package com.bankingeen.backofficeservice.controller;

import com.bankingeen.backofficeservice.model.contract.checker.ApproveDeclineRequest;
import com.bankingeen.backofficeservice.model.contract.checker.ApproveDeclineResponse;
import com.bankingeen.backofficeservice.model.contract.checker.GetApprovementListRequest;
import com.bankingeen.backofficeservice.model.contract.checker.GetApprovementListResponse;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListRequest;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListResponse;
import com.bankingeen.backofficeservice.service.CheckerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checker")
public class CheckerController {

    private final CheckerService checkerService;

    public CheckerController(CheckerService checkerService) {
        this.checkerService = checkerService;
    }

    @PostMapping(value = "/approvement/list/v1")
    public GetApprovementListResponse getApprovementList(GetApprovementListRequest request) {

        return checkerService.getApprovementList(request);
    }

    @PostMapping(value = "/approve-decline/v1")
    public ApproveDeclineResponse approveDecline(ApproveDeclineRequest request) {

        return checkerService.approveDecline(request);
    }
}
