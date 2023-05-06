package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.Job;

public interface JobServiceInterface {
	
	// CRUD functions
	public List<Job> listJobs();

	public Job saveJob(Job job);

	public Job jobById(Long id);

	public Job updateJob(Job job);

	public void deleteJob(Long id);

}
