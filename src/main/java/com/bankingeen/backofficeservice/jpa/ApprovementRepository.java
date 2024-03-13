package com.bankingeen.backofficeservice.jpa;

import com.bankingeen.backofficeservice.model.entity.Approvement;
import com.bankingeen.backofficeservice.model.entity.BOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovementRepository extends JpaRepository<Approvement,Long>, JpaSpecificationExecutor<Approvement> {

      List<Approvement> findByScenarioId(Long scenarioId);

}
