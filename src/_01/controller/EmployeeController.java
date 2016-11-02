package _01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class EmployeeController extends MultiActionController {

	public String add(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg", "EmployeeController - add method()");
		return "_01/employee";
	}

	public ModelAndView remove(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("_01/employee");
		mv.addObject("msg", "EmployeeController - remove method()");
		return mv;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) {
		mv.setViewName("_01/employee");
		mv.addObject("msg", "EmployeeController - list method()");
		return mv;
	}
	
	public String myaddmethod(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg", "EmployeeController - myaddmethod method()");
		return "_01/employee";
	}

	public ModelAndView myremovemethod(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("_01/employee");
		mv.addObject("msg", "EmployeeController - myremovemethod method()");
		return mv;
	}

	public ModelAndView mylistmethod(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) {
		mv.setViewName("_01/employee");
		mv.addObject("msg", "EmployeeController - mylistmethod method()");
		return mv;
	}

}
