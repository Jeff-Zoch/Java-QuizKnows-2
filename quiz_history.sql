USE c_cs108_gangus;
  -- >>>>>>>>>>>> change this line so it uses your database, not mine <<<<<<<<<<<<<<<
  
DROP TABLE IF EXISTS quiz_history;
 -- remove table if it already exists and start from scratch

CREATE TABLE quiz_history (
user_id INT NOT NULL,
name VARCHAR(30) NOT NULL,
file VARCHAR(30) NOT NULL,
score INT NOT NULL,
date DATE NOT NULL
)