package _02.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import _02.domain.Job;
import _02.service.JobService;

@Controller
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	private JobService jobService;

	@RequestMapping("/all")
	public ModelAndView getAllJobs() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("jobs", jobService.getAllJobs());
		modelAndView.setViewName("01.view/jobList");

		System.out.println("..getAllJobs...");
		return modelAndView;

	}

	@RequestMapping("/loc/{location}")
	public String getJobsByLocation(@PathVariable("location") String jobLocation, Model model) {

		model.addAttribute("jobs", jobService.getJobsByLocation(jobLocation));
		
		System.out.println("...getJobsByLocation.... : " + jobLocation);
		return "01.view/jobList";

	}
	
	@RequestMapping("/{type}")
	public String getJobsByType(@PathVariable("type") String jobType, Model model) {

		model.addAttribute("jobs", jobService.getJobsByType(jobType));
		
		System.out.println("...getJobsByType.... : " + jobType);
		return "01.view/jobList";

	}

	@RequestMapping("/get")
	public String getJobById(@RequestParam("id") String jobId, Model model) {
		
		model.addAttribute("job", jobService.getJobById(jobId));
		
		System.out.println("..getJobById... : " + jobId);
		return "01.view/jobDetail";

	}

	@RequestMapping("/filter/{ByCriteria}")
	public String getJobsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams,
			Model model) {

		model.addAttribute("jobs", jobService.getJobsByFilter(filterParams));
		return "01.view/jobList";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewJobForm(@ModelAttribute("newJob") Job job) {
		
		job.setDescription("default description....");
		job.setLocation("Tablet");
		
		System.out.println("....getAddNewJobForm ...");
		return "01.view/addJob";

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addJobForm(@ModelAttribute("newJob") Job job) {

		jobService.addJob(job);
		return "redirect:/jobs/all";

	}
	
	@ModelAttribute("LocationList")
	public List<String> prepareManufacturerList() {
		List<String> manufactures = new ArrayList<String>();
		manufactures.add("İstanbul-Anadolu");
		manufactures.add("İstanbul-Avrupa");
		manufactures.add("İzmit");
		manufactures.add("Ankara");
		return manufactures;
	}

	@ModelAttribute("categoryList")
	public List<String> prepareCategoryList() {
		List<String> categories = new ArrayList<String>();
		categories.add("Laptop");
		categories.add("Tablet");
		categories.add("Smart Phone");
		return categories;
	}

	@ModelAttribute("conditionMap")
	public Map<Integer, String> prepareConditionMap() {
		Map<Integer, String> conditions = new HashMap<Integer, String>();
		conditions.put(0, "New");
		conditions.put(1, "Old");
		return conditions;
	}
	
}
