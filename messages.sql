USE c_cs108_gangus;
  -- >>>>>>>>>>>> change this line so it uses your database, not mine <<<<<<<<<<<<<<<
  
DROP TABLE IF EXISTS messages;
 -- remove table if it already exists and start from scratch

CREATE TABLE messages (
user_id INT NOT NULL,
sender_id INT NOT NULL,
type VARCHAR(20) NOT NULL,
description VARCHAR(100) NOT NULL, 
send_date DATE NOT NULL
)