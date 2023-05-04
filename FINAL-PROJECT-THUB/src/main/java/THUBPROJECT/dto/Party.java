package THUBPROJECT.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "parties")
public class Party {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String description;

	private User creator;

	@ManyToOne
	@JoinColumn(name="activity")
	private Activity activity;
	
	@ManyToOne
	@JoinColumn(name="game")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name="social")
	private Social social;

	@OneToMany(mappedBy = ("party"))
	private List<Message> messages;

	@OneToMany(mappedBy = ("party"))
	private List<PartyMemberList> partyMemberLists;

	// Constructors

	public Party(Long id, String title, String description, Game game, User creator, Activity activity, Social social) {

		this.id = id;
		this.title = title;
		this.description = description;
		this.game = game;
		this.creator = creator;
		this.activity = activity;
		this.social = social;
	}

	public Party() {

	}

	// Getters

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Game getGame() {
		return game;
	}

	public User getCreator() {
		return creator;
	}

	public Activity getActivity() {
		return activity;
	}

	public Social getSocial() {
		return social;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Message")
	public List<Message> getMessages() {
		return messages;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "PartyMemberList")
	public List<PartyMemberList> getPartyMemberLists() {
		return partyMemberLists;
	}

	// Setters

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public void setSocial(Social social) {
		this.social = social;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void setPartyMemberLists(List<PartyMemberList> partyMemberLists) {
		this.partyMemberLists = partyMemberLists;
	}

}
