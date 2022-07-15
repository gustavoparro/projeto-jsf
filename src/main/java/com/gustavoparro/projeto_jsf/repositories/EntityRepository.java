package com.gustavoparro.projeto_jsf.repositories;

import com.gustavoparro.projeto_jsf.configurations.DatabaseConnection;
import jakarta.persistence.EntityManager;

public abstract class EntityRepository<T> {

    protected EntityManager entityManager;

    public EntityRepository() {
        entityManager = DatabaseConnection.getEntityManager();
    }

    public T save(T entity) {
        return entityManager.merge(entity);
    }

    public void remove(T entity) {
        entityManager.remove(entity);
    }

    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    public void commitTransaction() {
        entityManager.getTransaction().commit();
    }

}
