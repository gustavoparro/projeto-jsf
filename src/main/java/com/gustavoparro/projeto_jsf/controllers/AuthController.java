package com.gustavoparro.projeto_jsf.controllers;

import com.gustavoparro.projeto_jsf.models.AppUser;
import com.gustavoparro.projeto_jsf.repositories.jpql.AppUserJPQLRepository;
import jakarta.enterprise.inject.Model;

import java.util.Optional;

@Model
public class AuthController {

    private AppUser appUser;

    private final AppUserJPQLRepository  appUserJPQLRepository = new AppUserJPQLRepository();

    public String signIn() {
        Optional<AppUser> optionalAppUser = appUserJPQLRepository.findByUsernameAndPassword(getAppUser().getUsername(), getAppUser().getPassword());

        if (optionalAppUser.isPresent()) {
            return "/home/index?faces-redirect=true";
        }

        return null;
    }

    public AppUser getAppUser() {
        if (appUser == null) {
            appUser = new AppUser();
        }

        return appUser;
    }

}
