/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "posts")
public class Post {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_submitted")
	private LocalDateTime time_submitted;

	@ManyToOne
	@JoinColumn(name = "creator")
	private User creator;

	@OneToMany(mappedBy = ("post_liked"))
	private List<Like> likes;

	@OneToMany(mappedBy = ("in_post"))
	private List<Comment> comments;

	// Constructors
	public Post() {
	}

	public Post(Long id, String content, User creator) {
		this.id = id;
		this.content = content;
		this.time_submitted = LocalDateTime.now();
		this.creator = creator;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public LocalDateTime getTime_submitted() {
		return time_submitted;
	}

	public User getCreator() {
		return creator;
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

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setTime_submitted(LocalDateTime time_submitted) {
		this.time_submitted = time_submitted;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
