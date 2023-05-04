package THUBPROJECT.dto;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="private_messages")
public class PrivMessage {

	/*	CREATE TABLE IF NOT EXISTS private_messages (
    		id INT AUTO_INCREMENT,
    		content VARCHAR(255) NOT NULL,
    		timestamp TIMESTAMP NOT NULL,
    		sender INT NOT NULL,
    		receiver INT NOT NULL,
    		PRIMARY KEY (id),
    		CONSTRAINT FK_private_messages_sender FOREIGN KEY (sender) REFERENCES users(id),
    		CONSTRAINT FK_private_messages_receiver FOREIGN KEY (receiver) REFERENCES users(id)
    	); */
	
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="content")
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestamp")
	private LocalDateTime timestamp;
	
	@ManyToOne
	@JoinColumn(name = "sender")
	private User sender;
	@JoinColumn(name = "receiver")
	private User receiver;
	
	// Constructors
	public PrivMessage() {}
	
	public PrivMessage(Long id, String content, LocalDateTime timestamp, User sender, User receiver) {
		this.id = id;
		this.content = content;
		this.timestamp = timestamp;
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
