package com.enigma.purba_resto_jpa.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class JpaUtil {
    private static String PERSISTENCE_UNIT_NAME = "purba_resto_jpa";
    private static EntityManagerFactory entityManagerFactory;
    private static void getEntityManagerFactory() {
        Map<String, Object> properties = Map.of(
                "jakarta.persistence.jdbc.user",System.getenv("DB_USERNAME"),
                "jakarta.persistence.jdbc.password",System.getenv("DB_PASSWORD")
        );
        entityManagerFactory = Persistence.
                createEntityManagerFactory(PERSISTENCE_UNIT_NAME,properties);
    }
    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            getEntityManagerFactory();
        }
        return entityManagerFactory.createEntityManager();
    }
    public static void shutDownEntityManager() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
            entityManagerFactory = null;
        }
    }
}
