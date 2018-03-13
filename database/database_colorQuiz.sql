DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP TABLE IF EXISTS answer;
DROP SEQUENCE IF EXISTS seq_answer_id;
DROP TABLE IF EXISTS result;
DROP SEQUENCE IF EXISTS seq_result_id;
DROP TABLE IF EXISTS white_questions;
DROP TABLE IF EXISTS blue_questions;
DROP TABLE IF EXISTS black_questions;
DROP TABLE IF EXISTS red_questions;
DROP TABLE IF EXISTS green_questions;



CREATE SEQUENCE seq_user_id;
CREATE TABLE users
(
	user_id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_user_id'),
	username VARCHAR(200) NOT NULL,
	post_date TIMESTAMP DEFAULT NOW()
);


CREATE TABLE white_questions
(
    question_word VARCHAR(200) NOT NULL
);
CREATE TABLE blue_questions
(
    question_word VARCHAR(200) NOT NULL
);
CREATE TABLE black_questions
(
    question_word VARCHAR(200) NOT NULL
);
CREATE TABLE red_questions
(
    question_word VARCHAR(200) NOT NULL
);
CREATE TABLE green_questions
(
    question_word VARCHAR(200) NOT NULL
);

CREATE SEQUENCE seq_answer_id;
CREATE TABLE answer
(
	answer_id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_answer_id'),
	user_id INTEGER NOT NULL REFERENCES users,
    color_type_key VARCHAR(200) NOT NULL,
    question_word VARCHAR(200) NOT NULL,
    answer_value INTEGER NOT NULL
);

CREATE SEQUENCE seq_result_id;
CREATE TABLE result
(
	result_id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_result_id'),
	user_id INTEGER NOT NULL REFERENCES users,
    white_counter INTEGER,
    blue_counter INTEGER,
    black_counter INTEGER,
    red_counter INTEGER,
    green_counter INTEGER
);


