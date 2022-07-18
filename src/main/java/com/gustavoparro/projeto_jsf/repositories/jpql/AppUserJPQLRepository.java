package com.gustavoparro.projeto_jsf.repositories.jpql;

import com.gustavoparro.projeto_jsf.models.AppUser;
import com.gustavoparro.projeto_jsf.repositories.EntityRepository;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class AppUserJPQLRepository extends EntityRepository<AppUser> {

    public Optional<AppUser> findById(Long id) {
        return Optional.of(entityManager.find(AppUser.class, id));
    }

    public Optional<AppUser> findByUsernameAndPassword(String username, String password) {
        String jpql = """
                SELECT u FROM AppUser u
                WHERE u.username like :username
                AND u.password like :password
        """;

        TypedQuery<AppUser> userTypedQuery = entityManager.createQuery(jpql, AppUser.class);
        userTypedQuery.setParameter("username", username);
        userTypedQuery.setParameter("password", password);

        return Optional.of(userTypedQuery.getSingleResult());
    }

}
