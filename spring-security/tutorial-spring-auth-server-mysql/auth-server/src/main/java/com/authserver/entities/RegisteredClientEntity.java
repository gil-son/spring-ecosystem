package com.authserver.entities;

import jakarta.persistence.*;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationResponseType;

import java.util.Set;

@Entity
@Table(name = "tb_registered_client")
public class RegisteredClientEntity {
    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String clientId;

    @Column(nullable = false)
    private String clientSecret;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_authorization_grant_type", joinColumns = @JoinColumn(name = "registered_client_id"))
    @Column(name = "authorization_grant_types")
    @Enumerated(EnumType.STRING)
    private Set<AuthorizationGrantType> authorizationGrantTypes;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_redirect_uri", joinColumns = @JoinColumn(name = "registered_client_id"))
    @Column(name = "redirect_uris")
    private Set<String> redirectUris;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_scope", joinColumns = @JoinColumn(name = "registered_client_id"))
    @Column(name = "scopes")
    private Set<String> scopes;

    @Column(nullable = false)
    private boolean requireAuthorizationConsent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public Set<AuthorizationGrantType> getAuthorizationGrantTypes() {
        return authorizationGrantTypes;
    }

    public void setAuthorizationGrantTypes(Set<AuthorizationGrantType> authorizationGrantTypes) {
        this.authorizationGrantTypes = authorizationGrantTypes;
    }

    public Set<String> getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(Set<String> redirectUris) {
        this.redirectUris = redirectUris;
    }

    public Set<String> getScopes() {
        return scopes;
    }

    public void setScopes(Set<String> scopes) {
        this.scopes = scopes;
    }

    public boolean isRequireAuthorizationConsent() {
        return requireAuthorizationConsent;
    }

    public void setRequireAuthorizationConsent(boolean requireAuthorizationConsent) {
        this.requireAuthorizationConsent = requireAuthorizationConsent;
    }
}