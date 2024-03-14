package com.bankingeen.backofficeservice.jpa;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DynamicEntityRepository {

    private final EntityManager entityManager;

    public DynamicEntityRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Object[]> getDynamicTableData(String tableName, String schema) {
        String sql = "SELECT * FROM " + schema + "." + tableName;
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }
}
