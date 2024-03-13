package com.bankingeen.backofficeservice.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "bouser",schema = "bankingeen")
@Entity
@Data
public class BOUser {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_CODE")
    private String userCode;

    @Column(name = "USER_PASS_ENCRYPT")
    private String userPassEncrypt;

    @Column(name = "ROLE_ID")
    private int roleId;
}
