package com.bankingeen.backofficeservice.jpa;

import com.bankingeen.backofficeservice.model.entity.BOTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BOTableRepository  extends JpaRepository<BOTable,Long>, JpaSpecificationExecutor<BOTable> {
    BOTable findByName(String tableName);
}
