INSERT INTO users (id, name, created, email, password, role) VALUES ('1', 'USER-1', CURRENT_TIMESTAMP, 'USER-1@EMAIL.COM', '11111111', 'USER');
INSERT INTO users (id, name, created, email, password, role) VALUES ('2', 'USER-2', CURRENT_TIMESTAMP, 'USER-2@EMAIL.COM', '11111111', 'USER');

INSERT INTO posts (id, created, text, from_id, to_id) VALUES ('1', '2017-04-15 20:19:01.519000', 'TEXT1', '2', '1');
INSERT INTO posts (id, created, text, from_id, to_id) VALUES ('2', '2017-04-15 20:19:01.519000', 'TEXT2', '2', '1');

INSERT INTO posts (id, created, text, from_id, to_id) VALUES ('3', '2017-04-15 20:19:01.519000', 'TEXT3', '1', '2');