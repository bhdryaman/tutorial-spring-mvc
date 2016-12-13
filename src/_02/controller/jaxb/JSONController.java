package _02.controller.jaxb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import _02.model.jaxb.Job;


@Controller
public class JSONController {

	//@RequestMapping(value="/getPerson")
	// In this way, it return xml because its entity use xml annotation!
	
	@RequestMapping(value="/getPerson",produces = "application/json")
	@ResponseBody
	public Job getStudent() {
		Job job =  new Job(101,"Google","İstanbul");
		return job;
	}

	@RequestMapping("/getPersonList")
	@ResponseBody
	public List<Job> getPersonList() {

		Job job1 = new Job(101,"Google","İstanbul");
		Job job2 = new Job(102,"Apple","İstanbul");
		Job job3 = new Job(103,"Microsoft","İstanbul");
		Job job4 = new Job(104,"Samsung","İstanbul");
		
		job1.setDescription("description...");
		job1.setType("part-time");
		job1.setIsPublic(true);
		job1.setPosition("Software Developer");

		List<Job> jobs = new ArrayList<Job>();
		jobs.add(job1);
		jobs.add(job2);
		jobs.add(job3);
		jobs.add(job4);

		return jobs;
	}

}
