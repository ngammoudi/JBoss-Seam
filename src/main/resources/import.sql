--#### script insert to the roles table###--
INSERT INTO roles (id, security_name )   VALUES (1, 'SuperAdmin');
INSERT INTO roles (id, security_name )   VALUES (2, 'Admin');
--#### script insert to the users table###--
INSERT INTO users(id, user_password, user_name, role_id) VALUES (1, 'admin', 'admin', 1);
INSERT INTO users(id, user_password, user_name, role_id) VALUES (2, 'user', 'user', 2);
