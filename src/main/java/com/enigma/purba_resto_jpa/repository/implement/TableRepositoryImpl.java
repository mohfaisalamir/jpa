package com.enigma.purba_resto_jpa.repository.implement;

import com.enigma.purba_resto_jpa.enitity.Table;
import com.enigma.purba_resto_jpa.repository.TableRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TableRepositoryImpl implements TableRepository {
    private EntityManager entityManager;
    public TableRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void save(Table table) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(table);
        transaction.commit();
    }

    @Override
    public Table findById(Integer id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Table table = entityManager.find(Table.class, id);
        transaction.commit();
        return table;
    }

    @Override
    public List<Table> findAll() {
        TypedQuery<Table> query = entityManager.createQuery("select t from Table t", Table.class);
        return query.getResultList();
    }

    @Override
    public void update(Table table) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(table);
        transaction.commit();
    }

    @Override
    public void delete(Table table) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(table);
        transaction.commit();
    }
}
