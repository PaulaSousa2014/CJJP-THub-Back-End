package THUBPROJECT.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "party_memberlists")
public class PartyMemberList {
	
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user")
	private User user;

	@ManyToOne
	@JoinColumn(name = "party")
	private Party party;

	// Constructors

	public PartyMemberList() {
	}

	public PartyMemberList(Long id, User user, Party party) {
		this.id = id;
		this.user = user;
		this.party = party;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Party getParty() {
		return party;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setParty(Party party) {
		this.party = party;
	}

}
