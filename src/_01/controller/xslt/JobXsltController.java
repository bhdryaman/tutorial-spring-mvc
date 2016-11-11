package _01.controller.xslt;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobXsltController {

	@RequestMapping(value = "/getjobs")
	public ModelAndView handleJobList(HttpServletRequest request, HttpServletResponse response) {

		InputStream inputStream = request.getServletContext().getResourceAsStream("/resources/xml/jobs.xml");
		ModelAndView model = new ModelAndView("_01/jobListXslt");
		model.addObject("xmlSource", inputStream);
		return model;

	}
	
}
