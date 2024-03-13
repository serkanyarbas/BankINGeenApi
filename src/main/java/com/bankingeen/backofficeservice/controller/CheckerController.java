package com.bankingeen.backofficeservice.controller;

import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListRequest;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListResponse;
import com.bankingeen.backofficeservice.service.CheckerService;
import com.bankingeen.backofficeservice.service.MakerService;
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

    @PostMapping(value = "/scenario/list/v1")
    public GetScenarioListResponse getScenarioList(GetScenarioListRequest request) {
        return checkerService.getScenarioList(request);
    }
}
