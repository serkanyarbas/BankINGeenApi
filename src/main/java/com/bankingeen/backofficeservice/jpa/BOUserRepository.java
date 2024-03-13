package com.bankingeen.backofficeservice.jpa;

import com.bankingeen.backofficeservice.model.entity.BOTable;
import com.bankingeen.backofficeservice.model.entity.BOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BOUserRepository extends JpaRepository<BOUser,Long>, JpaSpecificationExecutor<BOUser> {
    BOUser findByUserCode(String userCode);

    int findRoleIdByUserCode(String userCode);

}
