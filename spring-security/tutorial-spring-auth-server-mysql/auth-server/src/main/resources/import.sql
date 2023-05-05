INSERT INTO tb_registered_client (id, client_id, client_secret, require_authorization_consent)
VALUES ('1', 'client-server', '{noop}secret', true);

INSERT INTO tb_authorization_grant_type (registered_client_id, authorization_grant_types)
VALUES ('1', 'authorization_code'), ('1', 'refresh_token');

INSERT INTO tb_redirect_uri (registered_client_id, redirect_uris)
VALUES ('1', 'http://localhost:8085/login/oauth2/code/client-server-oidc');

INSERT INTO tb_scope (registered_client_id, scopes)
VALUES ('1', 'openid'), ('1', 'profile');


-- INSERT INTO tb_registered_client (id, client_id, client_secret, require_authorization_consent)
-- VALUES ('1', 'client-server', '{noop}secret', true);

-- INSERT INTO tb_authorization_grant_type (registered_client_id, authorization_grant_types)
-- VALUES ('1', 'authorization_code'), ('1', 'refresh_token');

-- INSERT INTO tb_redirect_uri (registered_client_id, redirect_uris)
-- VALUES ('1', 'http://localhost:8085/login/oauth2/code/client-server-oidc');

INSERT INTO tb_scope (registered_client_id, scopes)
VALUES ('1', 'openid'), ('1', 'profile');

select * from tb_registered_client;
select * from tb_authorization_grant_type;
select * from tb_redirect_uri;
select * from tb_scope;