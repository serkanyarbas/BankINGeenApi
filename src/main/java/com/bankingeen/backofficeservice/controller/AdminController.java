package com.bankingeen.backofficeservice.controller;

import com.bankingeen.backofficeservice.model.contract.admin.*;
import com.bankingeen.backofficeservice.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/table/list/v1")
    public ListTableResponse getTables() {

        return adminService.getTables();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/table/column/list/v1")
    public ListTableColumnResponse getTableColumns(@RequestBody ListTableColumnRequest request) {

        return adminService.getTableColumns(request);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/scenario/create/v1")
    public ScenarioCreateResponse scenarioCreate(@RequestBody ScenarioCreateRequest request) {

        return adminService.scenarioCreate(request);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/scenario/list/v1")
    public GetScenarioListResponse getScenarioList(@RequestBody GetScenarioListRequest request) {

        return adminService.getScenarioList(request);
    }
}
