package com.bankingeen.backofficeservice.jpa;

import com.bankingeen.backofficeservice.model.entity.ScenarioTableColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ScenarioTableColumnRepository extends JpaRepository<ScenarioTableColumn,Long>, JpaSpecificationExecutor<ScenarioTableColumn> {
}
