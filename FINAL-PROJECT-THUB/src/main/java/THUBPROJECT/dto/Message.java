package THUBPROJECT.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "messages")
public class Message {

	/*
	 * CREATE TABLE IF NOT EXISTS messages ( id INT NOT NULL AUTO_INCREMENT, content
	 * VARCHAR(300) NOT NULL, time_sent DATETIME DEFAULT CURRENT_TIMESTAMP, sender
	 * INT NOT NULL, party INT NOT NULL, PRIMARY KEY (id), CONSTRAINT
	 * FK_messages_sender FOREIGN KEY (sender) REFERENCES users(id) ON UPDATE
	 * CASCADE ON DELETE CASCADE, CONSTRAINT FK_messages_party FOREIGN KEY (party)
	 * REFERENCES parties(id) ON UPDATE CASCADE ON DELETE CASCADE );
	 */

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_sent")
	private LocalDateTime timeSent;

	@ManyToOne
	@JoinColumn(name = "sender")
	private User sender;

	@ManyToOne
	@JoinColumn(name = "party")
	private Party party;

	// Constructors
	public Message(Long id, String content, User sender, Party party) {
		this.id = id;
		this.content = content;
		this.timeSent = LocalDateTime.now();
		this.sender = sender;
		this.party = party;
	}

	public Message() {
		this.timeSent = LocalDateTime.now();
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public LocalDateTime getTimeSent() {
		return timeSent;
	}

	public User getSender() {
		return sender;
	}

	public Party getParty() {
		return party;
	}

	// Setters

	public void setId(Long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setTimeSent(LocalDateTime timeSent) {
		this.timeSent = timeSent;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public void setParty(Party party) {
		this.party = party;
	}

}
