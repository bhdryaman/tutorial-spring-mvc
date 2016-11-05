package _02.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import _02.domain.Job;

public interface JobRepositoryDAO {

	List<Job> getJobs();

	Job getJob(String jobId);

	List<Job> getJobsByLocation(String location);
	
	List<Job> getJobsByType(String type);

	Set<Job> getJobsByFilter(Map<String, List<String>> filterParams);

	void addJob(Job job);

}