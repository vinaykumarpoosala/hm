package com.hms.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hms.beans.Login;
import com.hms.beans.User;
import com.hms.exceptions.ApplicationException;
import com.hms.repositories.UserRepository;

@SuppressWarnings("unused")
@Controller
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * 
	 * @param login
	 * @param session
	 * @return validates user existence and set session attributes
	 */
	@PostMapping("/login")
	public String login(@ModelAttribute("login") Login login, HttpSession session) {

		System.out.println("login user name" + login.getUsername());

		User user = userRepository.searchByName(login.getUsername());
		if (user == null) {
			throw new ApplicationException("User Not found");
		}
		if (user.getPassword().equalsIgnoreCase(login.getPassword())) {

			session.setAttribute("Token", user.getUsername());
			session.setAttribute("userType", user.getUserType());
			return "forward:/profile";
		}
		return "login";
	}

	/**
	 * 
	 * @param model
	 * @return error message if user doesn't exists
	 */
	@ExceptionHandler(ApplicationException.class)
	public String handleException(Model model) {
		System.out.println("in exception handler of Login Controller");
		model.addAttribute("error", "Username Or Password Incorrect Please try again");
		return "error";
	}
}
