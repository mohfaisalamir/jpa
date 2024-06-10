package com.enigma.purba_resto_jpa.repository;

import com.enigma.purba_resto_jpa.enitity.Table;

import java.util.List;

public interface TableRepository {
    void save(Table table);
    Table findById(Integer id);
    List<Table> findAll();
    void update(Table table);
    void delete(Table table);
}
