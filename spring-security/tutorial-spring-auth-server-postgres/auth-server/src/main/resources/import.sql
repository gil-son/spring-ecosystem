  INSERT INTO TB_USER (username, password) VALUES ('user1', '{noop}password1');
  INSERT INTO TB_USER (username, password) VALUES ('user2', '{noop}password2');

  INSERT INTO TB_ROLE (role_name) VALUES ('ROLE_ADMIN');
  INSERT INTO TB_ROLE (role_name) VALUES ('ROLE_USER');

  INSERT INTO TB_USERS_ROLES (user_id, role_id) VALUES (1, 1);
  INSERT INTO TB_USERS_ROLES (user_id, role_id) VALUES (1, 2);
  INSERT INTO TB_USERS_ROLES (user_id, role_id) VALUES (2, 2);