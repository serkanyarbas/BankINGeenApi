package com.bankingeen.backofficeservice.jpa;

import com.bankingeen.backofficeservice.model.entity.BOTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BOTableRepository  extends JpaRepository<BOTable,Long>, JpaSpecificationExecutor<BOTable> {
    BOTable findByName(String tableName);

    @Query(value = "SELECT column_name FROM information_schema.columns WHERE  table_name = ?1", nativeQuery = true)
    List<String> findColumnNamesByTableName(String tableName);
}
