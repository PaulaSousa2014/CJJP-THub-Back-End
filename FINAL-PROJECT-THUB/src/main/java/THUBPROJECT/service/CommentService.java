/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import THUBPROJECT.dao.CommentDAO;
import THUBPROJECT.dto.Comment;
import THUBPROJECT.service.Interfaces.CommentServiceInterface;

@Service // Assign Service
public class CommentService implements CommentServiceInterface{

	// Load DAO
	@Autowired
	CommentDAO commentDAO;

	// CRUD functions
	public List<Comment> listComments() {
		return commentDAO.findAll();
	}

	public Comment saveComment(Comment comment) {
		return commentDAO.save(comment);
	}

	public Comment commentById(Long id) {
		return commentDAO.findById(id).get();
	}

	public Comment updateComment(Comment comment) {
		return commentDAO.save(comment);
	}

	public void deleteComment(Long id) {
		commentDAO.deleteById(id);
	}

}
