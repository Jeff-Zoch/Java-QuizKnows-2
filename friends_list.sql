USE c_cs108_gangus;
  -- >>>>>>>>>>>> change this line so it uses your database, not mine <<<<<<<<<<<<<<<
  
DROP TABLE IF EXISTS friends_list;
 -- remove table if it already exists and start from scratch

CREATE TABLE friends_list (
user_id INT NOT NULL,
friend_id INT NOT NULL
);

INSERT INTO 
user_profiles (user_id, friend_id) VALUES
	(1,3),
	(1,5),
	(3,5);
