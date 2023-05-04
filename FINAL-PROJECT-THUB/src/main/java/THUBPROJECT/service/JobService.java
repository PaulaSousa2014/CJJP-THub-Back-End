/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import THUBPROJECT.dao.JobDAO;
import THUBPROJECT.dto.Job;

@Service // Assign Service
public class JobService {

	// Load DAO
	@Autowired
	JobDAO jobDAO;

	// CRUD functions
	public List<Job> listJobs() {
		return jobDAO.findAll();
	}

	public Job saveJob(Job job) {
		return jobDAO.save(job);
	}

	public Job jobById(Long id) {
		return jobDAO.findById(id).get();
	}

	public Job updateJob(Job job) {
		return jobDAO.save(job);
	}

	public void deleteJob(Long id) {
		jobDAO.deleteById(id);
	}

}
