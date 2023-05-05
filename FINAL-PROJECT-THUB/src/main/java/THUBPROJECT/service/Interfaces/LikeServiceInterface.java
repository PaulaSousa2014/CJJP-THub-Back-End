package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.Like;

public interface LikeServiceInterface {
	
	// CRUD functions
	public List<Like> listLikes();

	public Like saveLike(Like like);

	public Like likeById(Long id);

	public Like updateLike(Like like);

	public void deleteLike(Long id);

}
