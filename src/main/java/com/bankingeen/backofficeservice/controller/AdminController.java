package com.bankingeen.backofficeservice.controller;

import com.bankingeen.backofficeservice.model.contract.admin.*;
import com.bankingeen.backofficeservice.service.AdminService;
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

    @PostMapping(value = "/table/list/v1")
    public ListTableResponse getTables(ListTableRequest listTableRequest) {

        return adminService.getTables(listTableRequest);
    }

    @PostMapping(value = "/table/column/list/v1")
    public ListTableColumnResponse getTableColumns(ListTableColumnRequest listTableColumnRequest) {

        return adminService.getTableColumns(listTableColumnRequest);
    }

    @PostMapping(value = "/page/create/v1")
    public ScenarioCreateResponse pageCreate(ScenarioCreateRequest pageCreateRequest) {

        return adminService.pageCreate(pageCreateRequest);
    }
}
