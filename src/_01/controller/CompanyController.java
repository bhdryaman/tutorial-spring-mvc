package _01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class CompanyController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("_01/companyList");
		modelAndView.addObject("msg", "Hello Page1Controller!");

		return modelAndView;
	}

}
