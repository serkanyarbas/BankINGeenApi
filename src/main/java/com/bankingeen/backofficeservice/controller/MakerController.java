package com.bankingeen.backofficeservice.controller;

import com.bankingeen.backofficeservice.model.contract.maker.*;
import com.bankingeen.backofficeservice.service.MakerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maker")
public class MakerController {

    private final MakerService makerService;

    public MakerController(MakerService makerService) {
        this.makerService = makerService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/scenario/list/v1")
    public GetScenarioListResponse getScenarioList(@RequestBody GetScenarioListRequest request) {

        return makerService.getScenarioList(request);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/scenario/record/list/v1")
    public GetScenarioRecordListResponse getScenarioRecordList(@RequestBody GetScenarioRecordListRequest request) {

        return makerService.getScenarioRecordList(request);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/approvement/v1")
    public SendForApprovementResponse sendForApprovement(@RequestBody SendForApprovementRequest request) {


        return makerService.sendForApprovement(request);
    }
}
