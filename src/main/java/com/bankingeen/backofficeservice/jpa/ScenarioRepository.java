package com.bankingeen.backofficeservice.jpa;

import com.bankingeen.backofficeservice.model.entity.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenarioRepository extends JpaRepository<Scenario,Long>, JpaSpecificationExecutor<Scenario> {

    List<Scenario> findByMakerRoleId(int roleId);

    List<Scenario> findByCheckerRoleId(int roleId);

}
