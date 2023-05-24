package THUBPROJECT.dto;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="private_messages")
public class PrivMessage {
	
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="content")
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "message_timestamp")
	private LocalDateTime timestamp;
	
	@ManyToOne
	@JoinColumn(name = "sender")
	private User sender;
	
	@ManyToOne
	@JoinColumn(name = "receiver")
	private User receiver;
	
	// Constructors
	public PrivMessage() {
		this.timestamp = LocalDateTime.now();
	}
	
	public PrivMessage(Long id, String content, User sender, User receiver) {
		this.id = id;
		this.content = content;
		this.timestamp = LocalDateTime.now();
		this.sender = sender;
		this.receiver = receiver;
	}

	// Setters and getters
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public Long getId() {
		return id;
	}
}
