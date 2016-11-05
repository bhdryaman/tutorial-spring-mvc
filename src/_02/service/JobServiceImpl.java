package _02.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _02.dao.JobRepositoryDAO;
import _02.domain.Job;


@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	private JobRepositoryDAO jobRepository;

	public List<Job> getAllJobs() {
		return jobRepository.getJobs();
	}

	public Job getJobById(String jobID) {
		return jobRepository.getJob(jobID);
	}
	
	public List<Job> getJobsByLocation(String location) {
		return jobRepository.getJobsByLocation(location);
	}
	
	public List<Job> getJobsByType(String type) {
		return jobRepository.getJobsByType(type);
	}

	public Set<Job> getJobsByFilter(Map<String, List<String>> filterParams) {
		return jobRepository.getJobsByFilter(filterParams);
	}
	
	public void addJob(Job job) {
		   jobRepository.addJob(job);
	}

}
