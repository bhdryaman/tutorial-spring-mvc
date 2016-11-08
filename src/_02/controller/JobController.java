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
import org.springframework.web.servlet.view.RedirectView;

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
		job.setId(333);
		job.setCompany("Amazon");
		job.setPosition("Software Architecture");

		System.out.println("....getAddNewJobForm ...");
		return "01.view/addJob";

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addJobForm(@ModelAttribute("newJob") Job job) {

		// there are different ways to redirect without appending url queries
		
		// http://stackoverflow.com/questions/13247239/spring-mvc-controller-redirect-without-parameters-being-added-to-my-url

		// <mvc:annotation-driven	enable-matrix-variables="true" ignore-default-model-on-redirect="true"/>
		System.out.println("....getAddNewJobForm.POST..."+job);
		jobService.addJob(job);
		//return "redirect:/jobs/add";

//	    RedirectView redirect = new RedirectView("/jobs/all", true);
//	    redirect.setExposeModelAttributes(false);
//	    return redirect;
	    
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("redirect:/jobs/all");
	    return modelAndView;

	}
	
	@ModelAttribute("LocationList")
	public List<String> prepareLocationList() {

		List<String> manufactures = new ArrayList<String>();
		manufactures.add("İstanbul-Anadolu");
		manufactures.add("İstanbul-Avrupa");
		manufactures.add("İzmit");
		manufactures.add("Ankara");
		return manufactures;

	}

	@ModelAttribute("isPublicMap")
	public Map<Integer, String> prepareIsPublicMap() {

		Map<Integer, String> conditions = new HashMap<Integer, String>();
		conditions.put(0, "No Publish");
		conditions.put(1, "Publish");
		return conditions;

	}
	
	@ModelAttribute("TypeList")
	public List<String> prepareTypeList() {

		List<String> manufactures = new ArrayList<String>();
		manufactures.add("full-time");
		manufactures.add("part-time");
		manufactures.add("other");
		return manufactures;

	}
	
}
