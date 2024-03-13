package com.bankingeen.backofficeservice.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "approvement",schema = "bankingeen")
@Entity
@Data
public class Approvement {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "SCENARIO_ID")
    private int scenarioId;

    @Column(name = "OLD_CONTENT")
    private String oldContent;

    @Column(name = "NEW_CONTENT")
    private String newContent;

    @Column(name = "MAKER_USER_ID")
    private int makerUserId;

    @Column(name = "CHECKER_USER_ID")
    private int checkerUserId;

    @Column(name = "STATUS")
    private String status;


}
