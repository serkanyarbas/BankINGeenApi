package com.bankingeen.backofficeservice.model.entity;


import jakarta.persistence.*;
import lombok.Data;

@Table(name = "SCENARIO_TABLE_COLUMN",schema = "bankingeen")
@Entity
@Data
public class ScenarioTableColumn {

    @Id
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TABLE_ID")
    private BOTable table;

    @ManyToOne
    @JoinColumn(name = "SCENARIO_ID")
    private Scenario scenario;

    @Column(name = "COLUMN_NAME")
    private String columnName;

    @Column(name = "EDITABLE")
    private boolean editable;

    @Column(name = "VISIBLE")
    private boolean visible;

    @Column(name = "IS_PRIMARY_KEY")
    private boolean isPrimaryKey;

    public ScenarioTableColumn(BOTable table, Scenario scenario, String columnName, boolean editable, boolean visible, boolean isPrimaryKey) {

        this.table = table;
        this.scenario = scenario;
        this.columnName = columnName;
        this.editable = editable;
        this.visible = visible;
        this.isPrimaryKey = isPrimaryKey;
    }
}
