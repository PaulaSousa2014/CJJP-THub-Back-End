package THUBPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import THUBPROJECT.dao.ActivityDAO;
import THUBPROJECT.dto.Activity;

@Service // Assign Service
public class ActivityService {

	// Load DAO
	@Autowired
	ActivityDAO activityDAO;

	// CRUD functions
	public List<Activity> listActivities() {
		return activityDAO.findAll();
	}

	public Activity saveActivity(Activity activity) {
		return activityDAO.save(activity);
	}

	public Activity activityById(Long id) {
		return activityDAO.findById(id).get();
	}

	public Activity updateActivity(Activity activity) {
		return activityDAO.save(activity);
	}

	public void deleteActivity(Long id) {
		activityDAO.deleteById(id);
	}

}