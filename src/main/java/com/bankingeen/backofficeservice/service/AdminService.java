package com.bankingeen.backofficeservice.service;

import com.bankingeen.backofficeservice.jpa.CityRepository;
import com.bankingeen.backofficeservice.model.City;
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
}
