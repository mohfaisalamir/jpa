package com.enigma.purba_resto_jpa.repository;

import com.enigma.purba_resto_jpa.enitity.Menu;

import java.util.List;

public interface MenuRepository {
    void save(Menu table);
    Menu findById(Integer id);
    List<Menu> findAll();
    void update(Menu table);
    void delete(Menu table);
}
