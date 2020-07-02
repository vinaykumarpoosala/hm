package com.hms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
/**
 * 
 * @author
 *
 */
public class HomeController {
	/**
	 * default home page
	 * 
	 * @return
	 */
	@GetMapping("/")
	public String goToHome() {
		System.out.println("in home controller");
		return "index";
	}

	// to home page i.e, index
	@GetMapping("/home")
	public String goHome() {
		System.out.println("in home controller");
		return "index";
	}

	// to login page
	@GetMapping("/goToLogin")
	public String goToLogin() {
		System.out.println("in go to login");
		return "login";
	}

	@GetMapping("/goToSearch")
	public String goToSearch() {
		System.out.println("in search gotoSearch");
		return "search";
	}

	/**
	 * 
	 * @return register page
	 */
	@GetMapping("/goToRegistration")
	public String goToRegisterUser() {
		System.out.println("in go to registration");
		return "register";
	}

	/**
	 * 
	 * @return updatePatient page
	 */
	@GetMapping("/goToUpdate")
	public String goToUpadtePatient() {
		System.out.println("in go to update patient");
		return "updatePatient";
	}

	/**
	 * 
	 * @return deletePatient page
	 */

	@GetMapping("/goToDelete")
	public String goToDeletePatient() {
		System.out.println("in go to delete patient");
		return "deletePatient";
	}

}
