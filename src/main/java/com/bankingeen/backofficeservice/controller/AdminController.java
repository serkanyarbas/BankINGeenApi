package com.bankingeen.backofficeservice.controller;

import com.bankingeen.backofficeservice.model.City;
import com.bankingeen.backofficeservice.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final CityService cityService;

    public AdminController(CityService cityService) {
        this.cityService = cityService;
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
    public PageCreateResponse pageCreate(PageCreateRequest pageCreateRequest) {

        return adminService.pageCreate(pageCreateRequest);
    }
}
