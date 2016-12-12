package _02.controller.jaxb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import _02.domain.Job;
import _02.domain.JobList;


@Controller
public class JAXBPersonController {

	@RequestMapping("/getJobXML")
	@ResponseBody
	public Job getJobXML() {
		return new Job(101,"Google","İstanbul");
	}

	@RequestMapping("/getJobListXML")
	@ResponseBody
	public JobList getPersonListXML() {
		
		Job job1 = new Job(101,"Google","İstanbul");
		Job job2 = new Job(102,"Apple","İstanbul");
		Job job3 = new Job(103,"Microsoft","İstanbul");
		Job job4 = new Job(104,"Samsung","İstanbul");
		
		job1.setType("full-time");
		
		List<Job> jobs = new ArrayList<Job>();
		jobs.add(job1);
		jobs.add(job2);
		jobs.add(job3);
		jobs.add(job4);

		JobList jobList = new JobList(jobs);

		return jobList;
	}
}