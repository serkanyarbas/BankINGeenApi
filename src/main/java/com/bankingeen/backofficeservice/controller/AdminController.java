package com.bankingeen.backofficeservice.controller;

import com.bankingeen.backofficeservice.model.contract.admin.*;
import com.bankingeen.backofficeservice.service.AdminService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ListTableColumnResponse getTableColumns(ListTableColumnRequest request) {

        return adminService.getTableColumns(request);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/scenario/create/v1")
    public ScenarioCreateResponse scenarioCreate(ScenarioCreateRequest request) {

        return adminService.scenarioCreate(request);
    }
}
