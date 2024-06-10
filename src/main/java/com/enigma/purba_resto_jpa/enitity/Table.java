package com.enigma.purba_resto_jpa.enitity;

public class Table {
    private Integer id;
    private String tableName;

    public Table(Integer id, String tableName) {
        this.id = id;
        this.tableName = tableName;
    }

    public Table() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    @Override
    public String toString() {
        return "\nCustomer    : " +
                "\n\tid             : " + id +
                "\n\tcustomerName   : " + tableName +
                "\n"+"-".repeat(30);
    }
}
