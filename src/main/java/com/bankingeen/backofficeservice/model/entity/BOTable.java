package com.bankingeen.backofficeservice.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "BOTABLE",schema = "bankingeen")
@Entity
@Data
public class BOTable {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SCHEMA")
    private String schema;

    @Column(name = "DESCRIPTION")
    private String description;
}
