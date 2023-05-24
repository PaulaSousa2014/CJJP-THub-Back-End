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
name_surname VARCHAR(255) DEFAULT NULL,
profile_img VARCHAR(255) DEFAULT '../../../assets/img/avatars/cat0.jpg',
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
    status BOOLEAN DEFAULT FALSE,
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
    content VARCHAR(255) NOT NULL,
    time_submitted DATETIME DEFAULT CURRENT_TIMESTAMP,
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
    time_submitted DATETIME DEFAULT CURRENT_TIMESTAMP,
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

INSERT INTO jobs (title, description) VALUES 
	('Front-End Developer', 'Creative bois'),
 	('Back-End Developer', 'Raging bois');

INSERT INTO offices (name, location) VALUES 
	('REDESSA', 'Somewhere in Reus around the cinemas lol'),
	('TSystems', 'Close to the hospital, still being built it seems');

INSERT INTO roles (name) VALUES 
	('ROLE_USER'),
	('ROLE_MOD'),
	('ROLE_ADMIN');

INSERT INTO users (username, password, email, name_surname, steam_username, position, office) VALUES 
	('javier', '$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS', 'javi@javi.com', 'JAVIER PÉREZ', 'javisteam', 1, 1),
	('camila', '$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS', 'cami@cami.com', 'CAMILA GARCIA', 'camisteam', 1, 1),
	('josep', '$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS', 'jose@jose.com', 'JOSEP MARIA PALLÀS','josesteam', 2, 2),
	('paula', '$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS', 'pauli@pauli.com','PAULA SOUSA', 'paulisteam', 2, 2);

INSERT INTO users (username, password, email) VALUES 	
	('testUser','$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS','testUser@test.com');

INSERT INTO user_roles (user, role) VALUES 
	(1, 1), (2, 1), (3, 1),  (4, 1),  (1, 3), (2, 3), (3, 3), (4, 3), (5,1);

INSERT INTO friend_requests (sender_request, receiver_request) VALUES (1,2);
INSERT INTO friend_requests (sender_request, receiver_request) VALUES (2,3);
INSERT INTO friend_requests (sender_request, receiver_request) VALUES (3,4);
INSERT INTO friend_requests (sender_request, receiver_request) VALUES (4,1);

INSERT INTO private_messages (content, sender, receiver) VALUES ('Message 1', 1, 3);
INSERT INTO private_messages (content, sender, receiver) VALUES ('Message 2', 2, 4);
INSERT INTO private_messages (content, sender, receiver) VALUES ('Message 3', 3, 1);
INSERT INTO private_messages (content, sender, receiver) VALUES ('Message 4', 4, 2);

INSERT INTO posts (content, creator) VALUES ('Cats are the best thing ever, I swear to god I have over 400 cats adopted already', 2);
INSERT INTO posts (content, creator) VALUES ('Testing', 3);

INSERT INTO likes (user_liked, post_liked) VALUES
	(4, 1),
	(1, 1),
	(2, 1),
	(3, 1),
	(1, 2),
	(2, 2),
	(4, 2);

INSERT INTO comments (content, comment_by, in_post) VALUES 
	('Theyre so cute! :D', 4, 1),
	('Meh', 1, 1),
	('Great post!', 3, 1),
	('I completely agree with you.', 3, 1),
	('Thanks for sharing this information.', 2, 2),
	('I found this post really helpful.', 1, 2),
	('Can you provide more details about this topic?', 2, 1),
	('I think you missed an important point in your argument.', 3, 2);

INSERT INTO socials (title, description, theme) VALUES 
	('Summer BBQ', 'Join us for a fun-filled afternoon of food and games!', 'Summer'),
	('Halloween Party', 'Get ready for a spooktacular night of costumes and fun!', 'Halloween'),
	('Christmas Dinner', 'Celebrate the holiday season with a delicious feast!', 'Christmas'),
	('New Year''s Eve Bash', 'Ring in the new year with drinks, dancing, and great company!', 'New Year'),
	('Networking Event', 'Meet new people and expand your professional network!', 'Business'),
	('Charity Fundraiser', 'Support a good cause and make a difference in your community!', 'Charity');

INSERT INTO games (title, description, playtime) VALUES 
	('The Legend of Zelda: Breath of the Wild', 'Action-adventure game developed and published by Nintendo', 240),
	('Grand Theft Auto V', 'Action-adventure game developed by Rockstar North and published by Rockstar Games', 360),
	('Minecraft', 'Sandbox video game developed and published by Mojang Studios', 720),
	('Overwatch', 'First-person shooter game developed and published by Blizzard Entertainment', 180),
	('The Witcher 3: Wild Hunt', 'Action role-playing game developed and published by CD Projekt', 180);


INSERT INTO activities (title, description, activity_type) VALUES 
	('Yoga Class', 'One-hour Vinyasa Flow yoga class', 'Fitness'),
	('Painting Workshop', 'Two-hour painting workshop with acrylic paints', 'Art'),
	('Book Club Meeting', 'Monthly book club meeting to discuss "The Great Gatsby"', 'Literature'),
	('Hiking Trip', 'Full-day hike in the nearby national park', 'Outdoors'),
	('Cooking Class', 'Three-hour cooking class on Italian cuisine', 'Food'),
	('Photography Walk', 'Two-hour photography walk in the city', 'Art'),
	('Wine Tasting', 'Two-hour wine tasting event with sommelier', 'Food and Drink');

INSERT INTO parties (title, description, creator, activity, social, game) VALUES 
	('Sarah\'s Graduation Party', 'Celebrate Sarah\'s graduation from college', 3, NULL, 1, NULL),
	('Summer BBQ', 'Get together with friends and family for a summer barbecue', 2, NULL, 2, NULL),
	('Dungeons and Dragons Night', 'Join us for an evening of tabletop gaming', 1, NULL, NULL, 3),
	('New Year\'s Eve Party', 'Ring in the new year with a party!', 4, NULL, 4, NULL),
	('Charity 5K Run', 'Participate in a charity 5K run for a good cause', 3, 5, NULL, NULL);

INSERT INTO party_memberlists (user, party) VALUES 
	(1,5), 	(1,4),	(1,3),	(1,2),	(1,1),	(2,5),	(2,3),	(2,4),	(2,4),	(3,5),	(3,4),	(3,2),	(4,5),
	(4,4),	(4,1),	(4,2);

INSERT INTO messages (content, sender, party)
VALUES 
	('Hi, are you coming to the party tonight?', 1, 3),
	('Yes, I am!', 2, 3),
	('Do you need a ride?', 1, 3),
	('No, thanks. I am driving there myself.', 2, 3),
	('Hey, did you see the new update on our project?', 3, 5),
	('No, what is it about?', 4, 5),
	('It is about the new feature that we are adding to our app.', 3, 5),
	('That sounds interesting! Let me take a look at it.', 4, 5);