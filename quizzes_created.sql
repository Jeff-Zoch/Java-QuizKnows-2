USE c_cs108_gangus;
  -- >>>>>>>>>>>> change this line so it uses your database, not mine <<<<<<<<<<<<<<<
  
DROP TABLE IF EXISTS quizzes_created;
 -- remove table if it already exists and start from scratch

CREATE TABLE quizzes_created (
user_id INT NOT NULL,
name VARCHAR(30) NOT NULL,
file VARCHAR(30) NOT NULL,
creation_date DATE NOT NULL,
modified_date DATE NOT NULL
)