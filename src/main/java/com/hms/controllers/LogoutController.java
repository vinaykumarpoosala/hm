package com.hms.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// remove modification
@SuppressWarnings("unused")
@Controller
public class LogoutController {
	
	/**
	 * 
	 * @param session
	 * @param model
	 * @return 
	 * removing session attributes and logging out user
	 */
	@GetMapping(value="/Logout")
	public String logout(HttpSession session , Model model )
	{
		session.removeAttribute("Token");
		session.removeAttribute("userType");
		session.invalidate();
		return "redirect:home";
		
	}

}
