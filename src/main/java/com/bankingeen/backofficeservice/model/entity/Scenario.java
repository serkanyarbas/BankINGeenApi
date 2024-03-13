package com.bankingeen.backofficeservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "SCENARIO",schema = "bankingeen")
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

    @OneToMany(mappedBy = "scenario")
    private List<ScenarioTableColumn> scenarioTableColumns;
}
