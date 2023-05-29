/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import THUBPROJECT.dto.Comment;
import THUBPROJECT.dto.User;
import THUBPROJECT.service.CommentService;

@RestController // Rest controller
@RequestMapping("/api")
public class CommentController {

	// Implement service
	@Autowired
	CommentService commentService;

	// Get Mappings
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/comments")
	public List<Comment> listComments() {
		return commentService.listComments();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/comments/{id}")
	public Comment commentById(@PathVariable(name = "id") Long id) {
		Comment commentxID = new Comment();

		commentxID = commentService.commentById(id);

		return commentxID;
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/comments/post/{id}")
	public List<Comment> commentsByPostId(@PathVariable(name = "id") Long id) {
		return commentService.listCommentsByPostId(id);
	}
	

	// Post Mappings
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/comments")
	public Comment saveComment(@RequestBody Comment comment) {
		return commentService.saveComment(comment);
	}

	@DeleteMapping("/comments/{id}")
	public void deleteComment(@PathVariable(name = "id") Long id, Authentication authentication) {
	    // Retrieve the authenticated user's details
	    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	    
	    // Check if the authenticated user has the role "ADMIN"
	    boolean isAdmin = userDetails.getAuthorities().stream()
	            .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));

	    // Retrieve the comment by its ID
	    Comment comment = commentService.commentById(id);
	    if (comment == null) {
	        // Comment not found
	        return;
	    }

	    // Get the comment creator
	    User commentCreator = comment.getComment_by();

	    // Check if the authenticated user is the comment creator or has the role "ADMIN"
	    if (!authentication.getName().equals(commentCreator.getUsername()) && !isAdmin) {
	        // User is not authorized to delete the comment
	        return;
	    }

	    // Delete the comment
	    commentService.deleteComment(id);
	}

}
