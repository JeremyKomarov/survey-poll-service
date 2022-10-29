DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS answer;
DROP TABLE IF EXISTS vote;

CREATE TABLE question (
    id INT(11) unsigned NOT NULL AUTO_INCREMENT,
    question varchar(300),
    PRIMARY KEY (id)
);

CREATE TABLE answer (
    id INT(11) unsigned NOT NULL AUTO_INCREMENT,
    question_id INT(11),
    answer VARCHAR(200),
    PRIMARY KEY (id),
    FOREIGN KEY (question_id) REFERENCES question(id)
);

CREATE TABLE vote (
    id INT(11) unsigned NOT NULL AUTO_INCREMENT,
    user_id INT(11),
    question_id INT(11),
    answer_id INT(11),
    PRIMARY KEY (id),
    FOREIGN KEY (question_id) REFERENCES question(id),
    FOREIGN KEY (answer_id) REFERENCES answer(id)
);

INSERT INTO question (question) VALUES
 ('Between the following, what do you most love to do?'),
 ('Where is your preferred place to travel?');

INSERT INTO answer (question_id, answer) VALUES
 (1, 'Watch TV'),
 (1, 'Play the computer'),
 (1, 'Hanging out with friends'),
 (1, 'Travel the world'),
 (2, 'USA'),
 (2, 'France'),
 (2, 'South America'),
 (2, 'Thailand');







