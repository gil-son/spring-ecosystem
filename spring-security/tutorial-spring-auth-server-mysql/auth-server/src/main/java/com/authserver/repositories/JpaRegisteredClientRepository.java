package com.authserver.repositories;

import com.authserver.entities.RegisteredClientEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class JpaRegisteredClientRepository implements RegisteredClientRepository {

    private final EntityManager entityManager;

    public JpaRegisteredClientRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(RegisteredClient registeredClient) {

    }

    @Override
    public RegisteredClient findById(String id) {
        TypedQuery<RegisteredClientEntity> query = entityManager.createQuery(
                "SELECT rc FROM RegisteredClientEntity rc WHERE rc.id = :id", RegisteredClientEntity.class);
        query.setParameter("id", id);

        try {
            RegisteredClientEntity entity = query.getSingleResult();
            return toRegisteredClient(entity);
        } catch (NoResultException ex) {
            throw new IllegalArgumentException("Registered client not found with id: " + id, ex);
        }
    }




    @Override
    public RegisteredClient findByClientId(String clientId) {
        RegisteredClientEntity entity = entityManager.find(RegisteredClientEntity.class, clientId);

        if (entity == null) {
            // throw new IllegalArgumentException("Registered client not found with clientId: " + clientId);
        }

        return toRegisteredClient(entity);
    }


    private RegisteredClient toRegisteredClient(RegisteredClientEntity entity) {
        return RegisteredClient.withId(entity.getId())
                .clientId(entity.getClientId())
                .clientSecret(entity.getClientSecret())
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(entity.getAuthorizationGrantTypes().iterator().next())
                .scope(entity.getScopes().toArray(new String[0]).toString())
                .clientSettings(ClientSettings.builder()
                        .requireAuthorizationConsent(entity.isRequireAuthorizationConsent())
                        .build())
                .build();
    }


}

