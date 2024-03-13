package com.bankingeen.backofficeservice.controller;

import com.bankingeen.backofficeservice.model.City;
import com.bankingeen.backofficeservice.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/list/v1")
    public ResponseEntity<List<City>> getCities() {
        List<City> cityList = cityService.getCityList();
        return ResponseEntity.ok(cityList);
    }
}
