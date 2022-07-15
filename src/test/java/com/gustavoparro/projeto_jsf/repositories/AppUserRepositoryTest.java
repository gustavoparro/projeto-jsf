package com.gustavoparro.projeto_jsf.repositories;

import com.gustavoparro.projeto_jsf.models.AppUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AppUserRepositoryTest {

    private final AppUserRepository userRepository = new AppUserRepository();

    @Test
    public void save() {
        AppUser appUser = new AppUser(null, "Gustavo Parro", "gustavoparro", "123456");

        userRepository.beginTransaction();
        appUser = userRepository.save(appUser);
        userRepository.commitTransaction();

        AppUser userSaved = userRepository.findById(appUser.getId());

        assertEquals(appUser, userSaved);
    }

    @Test
    public void remove() {
        AppUser appUser = new AppUser(null, "Gustavo Parro", "gustavoparro", "123456");

        userRepository.beginTransaction();
        appUser = userRepository.save(appUser);
        userRepository.commitTransaction();

        userRepository.beginTransaction();
        userRepository.remove(appUser);
        userRepository.commitTransaction();

        AppUser userRemoved = userRepository.findById(appUser.getId());

        assertNull(userRemoved);
    }

}
