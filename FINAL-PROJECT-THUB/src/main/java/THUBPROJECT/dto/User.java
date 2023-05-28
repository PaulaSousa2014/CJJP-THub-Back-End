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
	@Column(name = "name_surname")
	private String nameSurn;
	@Column(name = "profile_img")
	private String profile_img;
	@Column(name = "biography")
	private String biography;
	@Column(name = "steam_username")
	private String steam_username;

	@ManyToOne
	@JoinColumn(name = "position")
	private Job job;

	@ManyToOne
	@JoinColumn(name = "office")
	private Office office;

	@OneToMany(mappedBy = ("creator"))
	private List<Party> parties;

	@OneToMany(mappedBy = ("user"))
	private List<PartyMemberList> partyMembers;

	@OneToMany(mappedBy = ("sender"))
	private List<Message> message;

	@OneToMany(mappedBy = ("creator"))
	private List<Post> posts;

	@OneToMany(mappedBy = ("user_liked"))
	private List<Like> likes;

	@OneToMany(mappedBy = ("comment_by"))
	private List<Comment> comments;

	@OneToMany(mappedBy = ("userSender"))
	private List<Friend> reqsSent;

	@OneToMany(mappedBy = ("userReciever"))
	private List<Friend> reqsReceived;

	@OneToMany(mappedBy = ("sender"))
	private List<PrivMessage> msgsSent;

	@OneToMany(mappedBy = ("receiver"))
	private List<PrivMessage> msgsReceived;

	// Join with table user_roles
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user"), inverseJoinColumns = @JoinColumn(name = "role"))
	private Set<Role> roles = new HashSet<>();

	// Constructors
	public User() {
	}

	public User(Long id, String username, String password, String email, String nameSurn, String biography,
			String steam_username, Job job, Office office) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.nameSurn = nameSurn;
		this.biography = biography;
		this.steam_username = steam_username;
		this.job = job;
		this.office = office;
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.profile_img = "../../../assets/img/avatars/cat0.jpg";
		this.nameSurn = username;
	}

	public User(Long id, String username, String password, String email, String nameSurn, String profile_img,
			String biography, String steam_username, Job job, Office office, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.nameSurn = nameSurn;
		this.profile_img = profile_img;
		this.biography = biography;
		this.steam_username = steam_username;
		this.job = job;
		this.office = office;
		this.roles = roles;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getNameSurn() {
		return nameSurn;
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

	public String getProfile_img() {
		return profile_img;
	}

	public String getSteam_username() {
		return steam_username;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Party")
	public List<Party> getParties() {
		return parties;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "PartyMemberList")
	public List<PartyMemberList> getPartyMembers() {
		return partyMembers;
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
	public List<Friend> getReqsSent() {
		return reqsSent;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Friend")
	public List<Friend> getReqsReceived() {
		return reqsReceived;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "PrivMessage")
	public List<PrivMessage> getMsgsSent() {
		return msgsSent;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "PrivMessage")
	public List<PrivMessage> getMsgsReceived() {
		return msgsReceived;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public String getBiography() {
		return biography;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setNameSurn(String nameSurn) {
		this.nameSurn = nameSurn;
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

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}

	public void setPartyMembers(List<PartyMemberList> partyMembers) {
		this.partyMembers = partyMembers;
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

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setReqsSent(List<Friend> reqsSent) {
		this.reqsSent = reqsSent;
	}

	public void setReqsReceived(List<Friend> reqsReceived) {
		this.reqsReceived = reqsReceived;
	}

	public void setMsgsSent(List<PrivMessage> msgsSent) {
		this.msgsSent = msgsSent;
	}

	public void setMsgsReceived(List<PrivMessage> msgsReceived) {
		this.msgsReceived = msgsReceived;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

}
