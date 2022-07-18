package com.gustavoparro.projeto_jsf.repositories.jpql;

import com.gustavoparro.projeto_jsf.models.AppUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppUserJPQLRepositoryTest {

    private final AppUserJPQLRepository userRepository = new AppUserJPQLRepository();

    @Test
    public void save() {
        AppUser appUser = new AppUser(null, "Gustavo Parro", "gustavoparro", "123456");

        userRepository.beginTransaction();
        appUser = userRepository.save(appUser);
        userRepository.commitTransaction();

        AppUser userSaved = userRepository.findById(appUser.getId()).orElse(null);

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

        AppUser userRemoved = userRepository.findById(appUser.getId()).orElse(null);

        assertNull(userRemoved);
    }

    @Test
    public void findByUsername() {
        String username = "THEbrayan";
        String password = "123456";
        AppUser user = userRepository.findByUsernameAndPassword(username, password).orElse(null);

        assertNotNull(user);
        assertEquals(user.getUsername(), username);
    }

}
