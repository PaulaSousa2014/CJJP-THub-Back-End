package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.Comment;

public interface CommentServiceInterface {
	
	public List<Comment> listComments();

	public Comment saveComment(Comment comment);

	public Comment commentById(Long id);

	public Comment updateComment(Comment comment);

	public void deleteComment(Long id);

}
