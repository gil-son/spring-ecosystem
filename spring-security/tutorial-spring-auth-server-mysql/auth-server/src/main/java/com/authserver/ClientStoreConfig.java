package com.authserver;


import java.util.UUID;


import com.authserver.repositories.JpaRegisteredClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import com.authserver.repositories.JpaRegisteredClientRepository;

@Configuration
public class ClientStoreConfig {
     // Client known by AS, example of implementation in memory, but it could be database.

    private final JpaRegisteredClientRepository registeredClientRepository;

    @Autowired
    public ClientStoreConfig(JpaRegisteredClientRepository registeredClientRepository) {
        this.registeredClientRepository = registeredClientRepository;
    }

    @Bean
    JpaRegisteredClientRepository registeredClientRepository() {

        RegisteredClient registeredClient = registeredClientRepository.findByClientId("client-server");
        System.out.println("TEST"+registeredClient);

        if (registeredClient == null) {

            // throw new RuntimeException("Client not found");
        }

        return registeredClientRepository;
    }

    @Bean
    public RegisteredClient testRegisteredClient() {
        return RegisteredClient.withId("1")
                .clientId("client-server")
                .clientSecret("{noop}secret")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .redirectUri("http://127.0.0.1:8080/login/oauth2/code/client-server-oidc")
                .scope(OidcScopes.OPENID)
                .scope(OidcScopes.PROFILE)
                .clientSettings(ClientSettings.builder()
                        .requireAuthorizationConsent(true).build())
                .build();
    }

}
