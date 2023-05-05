DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS party_memberlists;
DROP TABLE IF EXISTS parties;
DROP TABLE IF EXISTS activities;
DROP TABLE IF EXISTS games;
DROP TABLE IF EXISTS socials;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS likes;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS private_messages;
DROP TABLE IF EXISTS friend_requests;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS offices;
DROP TABLE IF EXISTS jobs;

CREATE TABLE IF NOT EXISTS jobs (
id INT NOT NULL AUTO_INCREMENT,
title VARCHAR(255) NOT NULL,
description VARCHAR(255) DEFAULT NULL,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS offices (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
location VARCHAR(150)NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS roles (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
PRIMARY KEY (id)
); 

CREATE TABLE IF NOT EXISTS users (
id INT NOT NULL AUTO_INCREMENT,
username VARCHAR(255) UNIQUE NOT NULL,
password VARCHAR(255) NOT NULL,
email VARCHAR(255) UNIQUE NOT NULL,
steam_username VARCHAR(255) DEFAULT NULL,
position INT DEFAULT NULL,
office INT DEFAULT NULL,
PRIMARY KEY (id),
CONSTRAINT FK_users_position FOREIGN KEY (position) REFERENCES jobs(id) ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT FK_users_office FOREIGN KEY (office) REFERENCES offices(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS user_roles (
    id INT NOT NULL AUTO_INCREMENT,
    user INT NOT NULL, 
    role INT NOT NULL, 
    PRIMARY KEY (id),
    CONSTRAINT FK_roles_roles FOREIGN KEY (role) REFERENCES roles(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_user_roles FOREIGN KEY (user) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS friend_requests (
    id INT AUTO_INCREMENT,
    sender_request INT NOT NULL,
    receiver_request INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_friend_requests_sender FOREIGN KEY (sender_request) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_friend_requests_receiver FOREIGN KEY (receiver_request) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS private_messages (
    id INT AUTO_INCREMENT,
    content VARCHAR(255) NOT NULL,
    message_timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    sender INT NOT NULL,
    receiver INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_private_messages_sender FOREIGN KEY (sender) REFERENCES users(id),
    CONSTRAINT FK_private_messages_receiver FOREIGN KEY (receiver) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS posts (
    id INT AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(255) NOT NULL,
    creator INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_posts_creator FOREIGN KEY (creator) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS likes (
	id INT AUTO_INCREMENT,
    user_liked INT NOT NULL,
    post_liked INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_likes_user FOREIGN KEY (user_liked) REFERENCES users(id),
    CONSTRAINT FK_likes_post FOREIGN KEY (post_liked) REFERENCES posts(id)
);

CREATE TABLE IF NOT EXISTS comments (
	id INT AUTO_INCREMENT,
    content VARCHAR(255) NOT NULL,
    comment_by INT NOT NULL,
    in_post INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_comments_user FOREIGN KEY (comment_by) REFERENCES users(id),
	CONSTRAINT FK_comments_post FOREIGN KEY (in_post) REFERENCES posts(id)
);

CREATE TABLE IF NOT EXISTS socials (
	id INT AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    theme VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS games (
	id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    playtime INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS activities (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    activity_type VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS parties (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255) DEFAULT NULL,
    creator INT NOT NULL,
    activity INT DEFAULT NULL, 
    social INT DEFAULT NULL, 
    game INT DEFAULT NULL,
	PRIMARY KEY (id),
    CONSTRAINT FK_parties_game FOREIGN KEY (game) REFERENCES games(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_parties_creator FOREIGN KEY (creator) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_parties_activity FOREIGN KEY (activity) REFERENCES activities(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_parties_social FOREIGN KEY (social) REFERENCES socials(id) ON UPDATE CASCADE ON DELETE CASCADE

);

CREATE TABLE IF NOT EXISTS party_memberlists (
    id INT NOT NULL AUTO_INCREMENT,
    user INT NOT NULL,
    party INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_party_members_user FOREIGN KEY (user) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_party_members_party FOREIGN KEY (party) REFERENCES parties(id) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS messages (
    id INT NOT NULL AUTO_INCREMENT,
    content VARCHAR(300) NOT NULL,
    time_sent DATETIME DEFAULT CURRENT_TIMESTAMP,
    sender INT NOT NULL,
    party INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_messages_sender FOREIGN KEY (sender) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_messages_party FOREIGN KEY (party) REFERENCES parties(id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO jobs (title, description) VALUES ('Front-End Developer', 'Creative bois');
INSERT INTO jobs (title, description) VALUES ('Back-End Developer', 'Raging bois');

INSERT INTO offices (name, location) VALUES ('REDESA', 'Somewhere in Reus around the cinemas lol');
INSERT INTO offices (name, location) VALUES ('TSystems', 'Close to the hospital, still being built it seems');

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_MOD');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO users (username, password, email, steam_username, position, office) VALUES ('javier', 'javipass', 'javi@javi.com', 'javisteam', 1, 1);
INSERT INTO users (username, password, email, steam_username, position, office) VALUES ('camila', 'camipass', 'cami@cami.com', 'camisteam', 1, 1);
INSERT INTO users (username, password, email, steam_username, position, office) VALUES ('josep', 'josepass', 'jose@jose.com', 'josesteam', 2, 2);
INSERT INTO users (username, password, email) VALUES ('paula', 'paulipass', 'pauli@pauli.com');

INSERT INTO user_roles (user, role) VALUES (1, 1);
INSERT INTO user_roles (user, role) VALUES (2, 1);
INSERT INTO user_roles (user, role) VALUES (3, 1);
INSERT INTO user_roles (user, role) VALUES (4, 1);
INSERT INTO user_roles (user, role) VALUES (1, 3);
INSERT INTO user_roles (user, role) VALUES (2, 3);
INSERT INTO user_roles (user, role) VALUES (3, 3);
INSERT INTO user_roles (user, role) VALUES (4, 3);

INSERT INTO friend_requests (sender_request, receiver_request) VALUES (1,2);
INSERT INTO friend_requests (sender_request, receiver_request) VALUES (2,3);
INSERT INTO friend_requests (sender_request, receiver_request) VALUES (3,4);
INSERT INTO friend_requests (sender_request, receiver_request) VALUES (4,1);

INSERT INTO private_messages (content, sender, receiver) VALUES ('Message 1', 1, 3);
INSERT INTO private_messages (content, sender, receiver) VALUES ('Message 2', 2, 4);
INSERT INTO private_messages (content, sender, receiver) VALUES ('Message 3', 3, 1);
INSERT INTO private_messages (content, sender, receiver) VALUES ('Message 4', 4, 2);

INSERT INTO posts (title, content, creator) VALUES ('I love Cats!', 'Cats are the best thing ever, I swear to god I have over 400 cats adopted already', 2);
INSERT INTO posts (title, content, creator) VALUES ('Test', 'Testing', 3);

INSERT INTO likes (user_liked, post_liked) VALUES (4, 1);

INSERT INTO comments (content, comment_by, in_post) VALUES ('Theyre so cute! :D', 4, 1);
INSERT INTO comments (content, comment_by, in_post) VALUES ('Meh', 1, 1);

INSERT INTO socials (title, description, theme) VALUES ('Developers Memes', 'description 1', 'Memes');
INSERT INTO socials (title, description, theme) VALUES ('Title2', 'description 2', 'Memes');
INSERT INTO socials (title, description, theme) VALUES ('FAQ', 'description 3', 'FAQ-THub');
INSERT INTO socials (title, description, theme) VALUES ('Title4', 'description 4', 'Theme4');