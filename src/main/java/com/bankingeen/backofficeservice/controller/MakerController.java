package com.bankingeen.backofficeservice.controller;

import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListRequest;
import com.bankingeen.backofficeservice.model.contract.maker.GetScenarioListResponse;
import com.bankingeen.backofficeservice.service.MakerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maker")
public class MakerController {

    private final MakerService makerService;

    public MakerController(MakerService makerService) {
        this.makerService = makerService;
    }

    @PostMapping(value = "/scenario/list/v1")
    public GetScenarioListResponse getScenarioList(GetScenarioListRequest request) {


        return makerService.getScenarioList(request);
    }
}
