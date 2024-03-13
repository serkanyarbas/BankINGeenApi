package com.bankingeen.backofficeservice.jpa;

import com.bankingeen.backofficeservice.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityRepository extends JpaRepository<City,Long>, JpaSpecificationExecutor<City> {
}
