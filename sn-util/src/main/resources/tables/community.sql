CREATE TABLE community (
  id VARCHAR (255) NOT NULL,
  create_date TIMESTAMP NOT NULL,
  name VARCHAR (4000) NOT NULL,
  description VARCHAR (255),
  user_id VARCHAR (255) NOT NULL,
  wall_id VARCHAR (255)
);

ALTER TABLE community ADD PRIMARY KEY (id);

ALTER TABLE community ADD FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE community ADD FOREIGN KEY (wall_id) REFERENCES community_wall (id);
ALTER TABLE community_wall ADD FOREIGN KEY (community_id) REFERENCES community(id);