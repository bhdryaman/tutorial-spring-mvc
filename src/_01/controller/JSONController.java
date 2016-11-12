package _01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import _02.domain.Job;


@Controller
public class JSONController {

	@RequestMapping("/getJob")
	@ResponseBody 
	public Job getJob() {
		return new Job(101, "Apple", "İstanbul");
	}

	@RequestMapping("/getJobList")
	@ResponseBody
	public List<Job> getJobList() {

		Job job1 = new Job(101, "Apple", "İstanbul");
		Job job2 = new Job(102, "Google", "İstanbul");
		Job job3 = new Job(103, "Microsoft", "İstanbul");
		
		List<Job> jobList = new ArrayList<Job>();
		jobList.add(job1);
		jobList.add(job2);
		jobList.add(job3);
		
		return jobList;

	}

}
