package _01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value = "/helloSpringMVC", method = RequestMethod.GET)
	public String handleRequest(ModelMap model) {
		System.out.println("...handleRequest...");
		String message = "Hello from handleRequest()";
		model.addAttribute("msg", message);
		return "_01/hello";
	}
	
	@RequestMapping(value={"/hello", "/hi", "/greetings"}, method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "_01/hello";
    }
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("greeting", "index In HelloController");
        return "_01/hello";
    }

}