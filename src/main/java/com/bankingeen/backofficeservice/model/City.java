package com.bankingeen.backofficeservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Table(name = "CITY",schema = "bankingeen")
@Entity
@Data
public class City {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name="NAME")
    private String name;

}
