package THUBPROJECT.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "friend_requests")
public class Friend {
	
	/*	CREATE TABLE IF NOT EXISTS friend_requests (
    		id INT AUTO_INCREMENT,
    		user_1 INT NOT NULL,
    		user_2 INT NOT NULL,
    		PRIMARY KEY (id),
    		CONSTRAINT FK_friend_requests FOREIGN KEY (user_1) REFERENCES users(id)
		);*/
	
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="user_1")
	private User user1;
	@Column(name="user_2")
	private User user2;
	
	// Constructors
	public Friend() {}
	
	public Friend(Long id, User user1, User user2) {
		this.id = id;
		this.user1 = user1;
		this.user2 = user2;
	}

	// Setters and getters
	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public Long getId() {
		return id;
	}	
}
