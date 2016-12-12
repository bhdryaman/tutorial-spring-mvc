package _02.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "job-list")
public class JobList {

	private List<Job> jobList;

	@XmlElement(name = "job-definition")
	public List<Job> getJobList() {
		return jobList;
	}

	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}

	public JobList() {
		super();
	}

	public JobList(List<Job> jobList) {
		super();
		this.jobList = jobList;
	}

}
