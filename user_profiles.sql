USE c_cs108_gangus;
  -- >>>>>>>>>>>> change this line so it uses your database, not mine <<<<<<<<<<<<<<<
  
DROP TABLE IF EXISTS user_profiles;
 -- remove table if it already exists and start from scratch

CREATE TABLE user_profiles (
user_id INT NOT NULL AUTO_INCREMENT,
username VARCHAR(30) NOT NULL,
password VARCHAR(60) NOT NULL,
is_admin INT NOT NULL,
unread_messages INT NOT NULL,
PRIMARY KEY (user_id)
);

INSERT INTO 
user_profiles (username, password, is_admin, unread_messages) VALUES
	("gangus", "password", 1, 0),
	("sfenerin", "1234", 1, 0),
	("jzoch", "asdf", 1, 0);
