/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import THUBPROJECT.dto.Like;

public interface LikeDAO extends JpaRepository<Like, Long> {
	
}
