package THUBPROJECT.dto;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

	/* CREATE TABLE IF NOT EXISTS users (
		id INT NOT NULL AUTO_INCREMENT,
		username VARCHAR(255) NOT NULL,
		password VARCHAR(255) NOT NULL,
		email VARCHAR(255) NOT NULL,
		steam_username VARCHAR(255) NOT NULL,
		position INT NOT NULL,
		office INT NOT NULL,
		PRIMARY KEY (id),
		CONSTRAINT FK_users_position FOREIGN KEY (position) REFERENCES jobs(id) ON UPDATE CASCADE ON DELETE CASCADE,
		CONSTRAINT FK_users_office FOREIGN KEY (office) REFERENCES offices(id) ON UPDATE CASCADE ON DELETE CASCADE
		); */
	
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="steam_username")
	private String steam_username;
	
	// Constructors
	public User(){}
	
	public User(Long id, String username, String password, String email, String steam_username) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.steam_username = steam_username;
	}
	
	// Getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSteam_username() {
		return steam_username;
	}

	public void setSteam_username(String steam_username) {
		this.steam_username = steam_username;
	}

	public Long getId() {
		return id;
	}
}
