package _02.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import _02.domain.Job;


public interface JobService {

	public List<Job> getAllJobs();

	public Job getJobById(String jobId);

	public List<Job> getJobsByLocation(String location);
	
	public List<Job> getJobsByType(String type);

	public Set<Job> getJobsByFilter(Map<String, List<String>> filterParams);

	public void addJob(Job job);
}
