package com.gustavoparro.projeto_jsf.models;

import com.gustavoparro.projeto_jsf.EntityManagerTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppUserTest extends EntityManagerTest {

    @Test
    public void save() {
        AppUser appUser = new AppUser(null, "Gustavo Parro", "gustavoparro", "123456");

        entityManager.getTransaction().begin();
        entityManager.persist(appUser);
        entityManager.getTransaction().commit();

        entityManager.clear();

        AppUser userPersisted = entityManager.find(AppUser.class, appUser.getId());

        assertEquals(appUser, userPersisted);
    }

}
