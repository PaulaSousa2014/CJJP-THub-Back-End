/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import THUBPROJECT.dao.LikeDAO;
import THUBPROJECT.dto.Like;
import THUBPROJECT.service.Interfaces.LikeServiceInterface;

@Service // Assign Service
public class LikeService implements LikeServiceInterface{

	// Load DAO
	@Autowired
	LikeDAO likeDAO;

	// CRUD functions
	public List<Like> listLikes() {
		return likeDAO.findAll();
	}

	public Like saveLike(Like like) {
		return likeDAO.save(like);
	}

	public Like likeById(Long id) {
		return likeDAO.findById(id).get();
	}

	public Like updateLike(Like like) {
		return likeDAO.save(like);
	}

	public void deleteLike(Long id) {
		likeDAO.deleteById(id);
	}
	
	public long numberOfLikes() {
		return likeDAO.count();
	}

}
