/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import THUBPROJECT.dto.Job;

public interface JobDAO extends JpaRepository<Job, Long> {

}
