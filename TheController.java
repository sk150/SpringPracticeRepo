package com.example;

//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TheController {
	
	/*@RequestMapping("/secure/{message}")
	public String secureWelcome(@PathVariable("message") String message){
		return message+" :: SECURE LINK....";
	}*/
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String testWelcome() {
        return "welcome";
    }
	
	 @RequestMapping(value="/", method = RequestMethod.GET)
	    public ModelAndView visitHome() {
	        return new ModelAndView("index");
	    }
	
	 @RequestMapping(value="/admin", method = RequestMethod.GET)
	    public ModelAndView visitAdmin() {
	        ModelAndView model = new ModelAndView("admin");
	        model.addObject("title", "Admministrator Control Panel");
	        model.addObject("message", "This page demonstrates how to use Spring security.");
	         
	        return model;
	    }
}
