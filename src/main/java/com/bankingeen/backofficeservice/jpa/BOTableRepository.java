package com.bankingeen.backofficeservice.jpa;

import com.bankingeen.backofficeservice.model.entity.BOTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BOTableRepository  extends JpaRepository<BOTable,Long>, JpaSpecificationExecutor<BOTable> {
}
