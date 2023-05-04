/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "likes")
public class Like {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_liked")
	private User user_liked;

	@ManyToOne
	@JoinColumn(name = "post_liked")
	private Post post_liked;

	// Constructors
	public Like() {
	}

	public Like(Long id, User user_liked, Post post_liked) {
		this.id = id;
		this.user_liked = user_liked;
		this.post_liked = post_liked;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public User getUser_liked() {
		return user_liked;
	}

	public Post getPost_liked() {
		return post_liked;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setUser_liked(User user_liked) {
		this.user_liked = user_liked;
	}

	public void setPost_liked(Post post_liked) {
		this.post_liked = post_liked;
	}

}
