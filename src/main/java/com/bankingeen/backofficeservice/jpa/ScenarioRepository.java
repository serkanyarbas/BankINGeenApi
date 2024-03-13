package com.bankingeen.backofficeservice.jpa;

import com.bankingeen.backofficeservice.model.entity.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioRepository extends JpaRepository<Scenario,Long>, JpaSpecificationExecutor<Scenario> {
}