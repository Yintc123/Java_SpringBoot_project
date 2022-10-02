package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MvcController {
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView("index");
		mav.addObject("message", "Greeting message from controller");
		System.out.println("sayHello got called");
		return mav;
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mav=new ModelAndView("register");
		System.out.println("register got called");
		return mav;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav=new ModelAndView("login");
		System.out.println("login got called");
		return mav;
	}
	
	@RequestMapping("/Hello")
	public ModelAndView sayHello() {
		ModelAndView mav=new ModelAndView("home");
		mav.addObject("message", "Greeting message from controller");
		System.out.println("sayHello got called");
		return mav;
	}
}
