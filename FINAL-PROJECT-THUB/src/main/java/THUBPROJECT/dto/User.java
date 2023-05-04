package THUBPROJECT.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "steam_username")
	private String steam_username;

	@ManyToOne
	@JoinColumn(name = "position")
	private Job job;

	@ManyToOne
	@JoinColumn(name = "office")
	private Office office;

	@OneToMany(mappedBy = ("Party"))
	private List<Party> party;

	@OneToMany(mappedBy = ("PartyMemberList"))
	private List<PartyMemberList> party_member;

	@OneToMany(mappedBy = ("Message"))
	private List<Message> message;

	@OneToMany(mappedBy = ("Post"))
	private List<Post> posts;

	@OneToMany(mappedBy = ("Like"))
	private List<Like> likes;

	@OneToMany(mappedBy = ("Comment"))
	private List<Comment> comments;

	@OneToMany(mappedBy = ("Friend"))
	private List<Friend> friends;

	@OneToMany(mappedBy = ("PrivMessage"))
	private List<PrivMessage> privMessages;

	// Join with table user_roles
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	// Constructors
	public User() {
	}

	public User(Long id, String username, String password, String email, String steam_username, Job job,
			Office office) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.steam_username = steam_username;
		this.job = job;
		this.office = office;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getSteam_username() {
		return steam_username;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Party")
	public List<Party> getParty() {
		return party;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "PartyMemberList")
	public List<PartyMemberList> getParty_member() {
		return party_member;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Message")
	public List<Message> getMessage() {
		return message;
	}

	public Office getOffice() {
		return office;
	}

	public Job getJob() {
		return job;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Post")
	public List<Post> getPosts() {
		return posts;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Like")
	public List<Like> getLikes() {
		return likes;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Comment")
	public List<Comment> getComments() {
		return comments;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Friend")
	public List<Friend> getFriends() {
		return friends;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "PrivMessage")
	public List<PrivMessage> getPrivMessages() {
		return privMessages;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSteam_username(String steam_username) {
		this.steam_username = steam_username;
	}

	public void setParty(List<Party> party) {
		this.party = party;
	}

	public void setParty_member(List<PartyMemberList> party_member) {
		this.party_member = party_member;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}

	public void setPrivMessages(List<PrivMessage> privMessages) {
		this.privMessages = privMessages;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
