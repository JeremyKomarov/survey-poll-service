DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS answer;
DROP TABLE IF EXISTS vote;

CREATE TABLE question (
    id INT unsigned NOT NULL AUTO_INCREMENT,
    question varchar(300) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE answer (
    id INT unsigned NOT NULL AUTO_INCREMENT,
    q_id INT NOT NULL,
    answer VARCHAR(200),
    PRIMARY KEY (id),
    FOREIGN KEY (q_id) REFERENCES question(id)
);

CREATE TABLE vote (
    id INT unsigned NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    question_id INT NOT NULL,
    answer_id INT NOT NULL,

    PRIMARY KEY (id ),
    FOREIGN KEY (question_id) REFERENCES question(id),
    FOREIGN KEY (answer_id) REFERENCES answer(id)
);

INSERT INTO question (question) VALUES
 ('Between the following, what do you most love to do?'),
 ('Where is your preferred place to travel?');

INSERT INTO answer (q_id, answer) VALUES
 (1, 'Watch TV'),
 (1, 'Play the computer'),
 (1, 'Hanging out with friends'),
 (1, 'Travel the world'),
 (2, 'USA'),
 (2, 'France'),
 (2, 'South America'),
 (2, 'Thailand');

 INSERT INTO vote (user_id, question_id, answer_id) VALUES
  (1, 1, 2),
  (2, 1, 3),
  (1, 1, 1),
  (2, 2, 1),
  (1, 2, 1),









