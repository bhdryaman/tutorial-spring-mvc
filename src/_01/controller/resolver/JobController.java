package _01.controller.resolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobController {

	@RequestMapping("/job-list")
	public ModelAndView handlePage1() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("beanViewJobList");
		mv.addObject("msg", "XmlViewResolver handle beanViewJoblist");
		return mv;
	}

	@RequestMapping("/job")
	public ModelAndView handlePage2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("beanViewJob");
		mv.addObject("msg", "XmlViewResolver handle beanViewJob");
		return mv;
	}

}