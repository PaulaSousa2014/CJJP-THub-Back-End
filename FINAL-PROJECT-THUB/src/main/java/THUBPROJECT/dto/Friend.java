package THUBPROJECT.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "friend_requests")
public class Friend {
	
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_1")
	private User user1;
	
	@ManyToOne
	@JoinColumn(name="user_2")
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
