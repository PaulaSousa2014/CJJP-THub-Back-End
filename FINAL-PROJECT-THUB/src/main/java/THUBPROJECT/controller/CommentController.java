/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import THUBPROJECT.dto.Comment;
import THUBPROJECT.service.CommentService;

@RestController // Rest controller
@RequestMapping("/api")
public class CommentController {

	// Implement service
	@Autowired
	CommentService commentService;

	// Get Mappings
	@GetMapping("/comments")
	public List<Comment> listComments() {
		return commentService.listComments();
	}

	@GetMapping("/comments/{id}")
	public Comment commentById(@PathVariable(name = "id") Long id) {
		Comment commentxID = new Comment();

		commentxID = commentService.commentById(id);

		return commentxID;
	}

	// Post Mappings
	@PostMapping("/comments")
	public Comment saveComment(@RequestBody Comment comment) {
		return commentService.saveComment(comment);
	}

	// Put Mappings
	@PutMapping("/comments/{id}")
	public Comment updateComment(@PathVariable(name = "id") Long id, @RequestBody Comment comment) {
		Comment selectedComment = new Comment(id, comment.getContent(), comment.getComment_by(), comment.getIn_post());
		Comment updatedComment = new Comment();

		updatedComment = commentService.updateComment(selectedComment);
		return updatedComment;
	}

	// Delete Mappings
	@DeleteMapping("/comments/{id}")
	public void deleteComment(@PathVariable(name = "id") Long id) {
		commentService.deleteComment(id);
	}

}
