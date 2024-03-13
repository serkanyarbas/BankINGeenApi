package com.bankingeen.backofficeservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Table(name = "scenario",schema = "bankingeen")
@Entity
@Data
public class Scenario {

    @Id
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "TABLE_ID")
    private BOTable table;

    @Column(name = "SCENARIO_NAME")
    private String scenarioName;

    @Column(name = "SCENARIO_DESC")
    private String scenarioDesc;

    @Column(name = "FILTER_QUERY")
    private String filterQuery;

    @Column(name = "MAKER_ROLE_ID")
    private int makerRoleId;

    @Column(name = "CHECKER_ROLE_ID")
    private int checkerRoleId;

    @OneToMany(mappedBy = "scenario")
    private List<ScenarioTableColumn> scenarioTableColumns;
}
