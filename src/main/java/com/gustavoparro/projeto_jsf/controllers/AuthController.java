package com.gustavoparro.projeto_jsf.controllers;

import com.gustavoparro.projeto_jsf.models.AppUser;
import jakarta.enterprise.inject.Model;

@Model
public class AuthController {

    private AppUser appUser;

    public void signIn() {
        System.out.println(appUser);
    }

    public AppUser getAppUser() {
        if (appUser == null) {
            appUser = new AppUser();
        }

        return appUser;
    }

}
