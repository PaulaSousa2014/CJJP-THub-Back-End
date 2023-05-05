package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.Activity;

public interface ActivityServiceInterface {

	// CRUD functions
	public List<Activity> listActivities();

	public Activity saveActivity(Activity activity);

	public Activity activityById(Long id);

	public Activity updateActivity(Activity activity);

	public void deleteActivity(Long id);
	
}
