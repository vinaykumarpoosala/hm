package com.hms.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hms.beans.Medicine;
import com.hms.exceptions.ApplicationException;
import com.hms.services.MedicineSerivice;
import com.hms.services.PatientService;

@Controller
public class MedicineController {

	@Autowired
	MedicineSerivice MedicineSerivice;

	@Autowired
	PatientService service;
	
	/**
	 * 
	 * @param id
	 * @param medicine
	 * @param model
	 * @param session
	 * @return
	 * adds medicine and removes the quantity in master medicine
	 */
	@RequestMapping(value = "/addMedicine", method = RequestMethod.POST)
	public String addMedicine(@RequestParam("patientId") String id, @ModelAttribute("medicine") Medicine medicine,
			Model model, HttpSession session) {
		if (session.getAttribute("Token") == null || session.getAttribute("Token") == "")
			return "home";
		service.addMedicine(id, medicine);
		return "redirect:search?patientId=" + id;
	}

	@ExceptionHandler(ApplicationException.class)
	public String handleResourceNotFoundException() {

		return "error";

	}

	@ExceptionHandler(ApplicationException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String handleNotFoundException() {
		return "error";
	}
}
