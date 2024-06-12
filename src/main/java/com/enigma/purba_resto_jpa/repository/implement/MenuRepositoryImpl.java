package com.enigma.purba_resto_jpa.repository.implement;

import com.enigma.purba_resto_jpa.enitity.Menu;
import com.enigma.purba_resto_jpa.repository.MenuRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MenuRepositoryImpl implements MenuRepository {
    private EntityManager entityManager;
    public MenuRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void save(Menu menu) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(menu);
        transaction.commit();
    }

    @Override
    public Menu findById(Integer id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Menu menu = entityManager.find(Menu.class, id);
        transaction.commit();
        return menu;
    }


    @Override
    public List<Menu> findAll() {
        TypedQuery<Menu> query = entityManager.createQuery("select m from Menu m", Menu.class);
        return query.getResultList();
    }

    @Override
    public void update(Menu menu) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(menu);
        transaction.commit();
    }

    @Override
    public void delete(Menu menu) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(menu);
        transaction.commit();
    }
}
