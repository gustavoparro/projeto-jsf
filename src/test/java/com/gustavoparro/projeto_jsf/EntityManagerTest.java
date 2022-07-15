package com.gustavoparro.projeto_jsf;

import com.gustavoparro.projeto_jsf.configurations.DatabaseConnection;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class EntityManagerTest {

    protected EntityManager entityManager;

    @BeforeEach
    public void setUpBeforeEach() {
        entityManager = DatabaseConnection.getEntityManager();
    }

    @AfterEach
    public void tearDownAfterEach() {
        entityManager.close();
    }

}
