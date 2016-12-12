package _02.controller.jaxb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import _02.domain.Job;
import _02.domain.JobList;
//import _02.jaxb.model.Job;
//import _02.jaxb.model.JobList;

@Controller
public class JAXBJobController {

	@RequestMapping("/getJobXML")
	public ModelAndView getEmployeeXML() {

		ModelAndView mv = new ModelAndView("marshallingView");
		Job job =  new Job(101,"Google","İstanbul");
		job.setDescription("description...");
		job.setType("part-time");
		job.setIsPublic(true);
		job.setPosition("Software Developer");
		mv.addObject(job);
		return mv;

	}

	@RequestMapping("/getJobListXML")
	public ModelAndView getJobListXML() {
		
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

		JobList jobList = new JobList(jobs);

		ModelAndView mv = new ModelAndView("marshallingView");
		mv.addObject(jobList);
		return mv;

	}

}