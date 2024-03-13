package com.bankingeen.backofficeservice.controller;

import com.bankingeen.backofficeservice.model.contract.checker.ApproveDeclineRequest;
import com.bankingeen.backofficeservice.model.contract.checker.ApproveDeclineResponse;
import com.bankingeen.backofficeservice.model.contract.checker.GetApprovementListRequest;
import com.bankingeen.backofficeservice.model.contract.checker.GetApprovementListResponse;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListRequest;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListResponse;
import com.bankingeen.backofficeservice.service.CheckerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checker")
public class CheckerController {

    private final CheckerService checkerService;

    public CheckerController(CheckerService checkerService) {
        this.checkerService = checkerService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/approvement/list/v1")
    public GetApprovementListResponse getApprovementList(@RequestBody GetApprovementListRequest request) {

        return checkerService.getApprovementList(request);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/approve-decline/v1")
    public ApproveDeclineResponse approveDecline(@RequestBody ApproveDeclineRequest request) {

        return checkerService.approveDecline(request);
    }
}
