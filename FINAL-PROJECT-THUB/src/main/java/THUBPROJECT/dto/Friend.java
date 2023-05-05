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
	@JoinColumn(name="sender_request")
	private User userSender;
	
	@ManyToOne
	@JoinColumn(name="receiver_request")
	private User userReciever;
	
	// Constructors
	public Friend() {}
	
	public Friend(Long id, User sender_request, User receiver_request) {
		this.id = id;
		this.userSender = sender_request;
		this.userReciever = receiver_request;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserSender() {
		return userSender;
	}

	public void setUserSender(User userSender) {
		this.userSender = userSender;
	}

	public User getUserReciever() {
		return userReciever;
	}

	public void setUserReciever(User userReciever) {
		this.userReciever = userReciever;
	}

	// Setters and getters
	
}
