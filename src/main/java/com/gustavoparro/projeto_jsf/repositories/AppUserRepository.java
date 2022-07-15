package com.gustavoparro.projeto_jsf.repositories;

import com.gustavoparro.projeto_jsf.models.AppUser;

public class AppUserRepository extends EntityRepository<AppUser> {

    public AppUser findById(Long id) {
        return entityManager.find(AppUser.class, id);
    }

}
