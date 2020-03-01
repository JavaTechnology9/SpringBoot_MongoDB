package com.javatechnology;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.support.ModelAndViewContainer;

@Controller
public class MogoController {
	@Autowired
	private MongoDao dao;
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		new ModelAndViewContainer().setRequestHandled(false);
		return "login";
	}
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public @ResponseBody Login loginProcess(Login login) {
		return dao.save(login);
	}
	

}
