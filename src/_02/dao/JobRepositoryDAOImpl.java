package _02.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import _02.domain.DummyData;
import _02.domain.Job;

@Repository
public class JobRepositoryDAOImpl implements JobRepositoryDAO {

	private List<Job> listOfJobs = new ArrayList<Job>();

	public JobRepositoryDAOImpl() {
		
		DummyData.prepareJobDatas(listOfJobs);
		
	}

	@Override
	public List<Job> getJobs() {
		return listOfJobs;
	}

	@Override
	public Job getJob(String jobId) {
		Job jobById = null;

		for (Job job : listOfJobs) {
			if (job != null && job.getId() != null && job.getId().equals(Integer.valueOf(jobId))) {
				jobById = job;
				break;
			}
		}

		return jobById;
	}

	@Override
	public List<Job> getJobsByLocation(String location) {

		List<Job> jobsByLocation = new ArrayList<Job>();

		for (Job job : listOfJobs) {
			if (location.equalsIgnoreCase(job.getLocation())) {
				jobsByLocation.add(job);
			}
		}

		return jobsByLocation;
	}
	
	public List<Job> getJobsByType(String type) {

		List<Job> jobsByType = new ArrayList<Job>();

		for (Job job : listOfJobs) {
			if (type.equalsIgnoreCase(job.getType())) {
				jobsByType.add(job);
			}
		}

		return jobsByType;
	}

	@Override
	public Set<Job> getJobsByFilter(Map<String, List<String>> filterParams) {

		Set<Job> jobsByType = new HashSet<Job>();
		Set<Job> jobsByLocation = new HashSet<Job>();

		Set<String> criterias = filterParams.keySet();

		if (criterias.contains("type")) {
			for (String kindOfJob : filterParams.get("type")) {
				for (Job job : listOfJobs) {
					if (kindOfJob.equalsIgnoreCase(job.getType())) {
						jobsByType.add(job);
					}
				}
			}
		}

		if (criterias.contains("location")) {
			for (String location : filterParams.get("location")) {
				jobsByLocation.addAll(this.getJobsByLocation(location));
			}
		}

		if (jobsByType.size() > 0 && jobsByLocation.size() > 0) {
			jobsByLocation.retainAll(jobsByType);
		} else {
			
			HashSet<Job> search = new HashSet<Job>();
			if (jobsByType.size() > 0) {
				search.addAll(jobsByType);
			} else {
				search.addAll(jobsByLocation);
			}
			
			return search;
		}

		return jobsByLocation;
	}
	
	public void addJob(Job job) {
		   listOfJobs.add(job);
	}

}
