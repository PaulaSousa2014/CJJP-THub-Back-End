package THUBPROJECT.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {

	/*	CREATE TABLE IF NOT EXISTS user_roles (
    		id INT NOT NULL AUTO_INCREMENT,
    		user INT NOT NULL, 
    		roles INT NOT NULL, 
    		PRIMARY KEY (id),
    		CONSTRAINT FK_roles_roles FOREIGN KEY (roles) REFERENCES roles(id) ON UPDATE CASCADE ON DELETE CASCADE,
    		CONSTRAINT FK_user_roles FOREIGN KEY (user) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE
		); */
	
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="roles")
	private Role role;
	
	// Contrsuctors
	public UserRole() {}
	
	public UserRole(Long id, User user, Role role) {
		this.id = id;
		this.user = user;
		this.role = role;
	}

	// Setter and getters
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}
}
