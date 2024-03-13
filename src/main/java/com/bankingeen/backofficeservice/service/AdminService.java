package com.bankingeen.backofficeservice.service;

import com.bankingeen.backofficeservice.jpa.CityRepository;
import com.bankingeen.backofficeservice.model.contract.admin.*;
import com.bankingeen.backofficeservice.model.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final CityRepository cityRepository;

    public AdminService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public List<City> getCityList(){
        return cityRepository.findAll();
    }

    public ListTableResponse getTables(ListTableRequest listTableRequest) {

        return null;
    }

    public ListTableColumnResponse getTableColumns(ListTableColumnRequest listTableColumnRequest) {

        return null;
    }

    public ScenarioCreateResponse pageCreate(ScenarioCreateRequest pageCreateRequest) {

        return null;
    }
}
