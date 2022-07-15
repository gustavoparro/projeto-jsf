package com.gustavoparro.projeto_jsf.configurations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseConnection {

    private static final EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("projeto_jsf");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
