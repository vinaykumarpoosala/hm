package com.hms.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.hms.beans.Patient;
import com.hms.exceptions.ApplicationException;
import com.hms.services.PatientService;

@Controller
public class UpdateAndDeleteController {

	@Autowired
	private PatientService service;

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/goToUpdate/searchById")
	public String searchPatientToUpdate(@RequestParam("patientId") String id, Model model) {

		Patient patient = service.searchPatientById(Long.parseLong(id));
		if (patient == null) {
			throw new ApplicationException("Patient Not Found");
		}
		model.addAttribute("patient", patient);
		return "updatePatient";
	}

	/**
	 * 
	 * @param patient
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatepatient", method = RequestMethod.POST)
	private String updatePatient(@Valid @ModelAttribute("newPatient") Patient patient, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			model.addAttribute("error", "Updation Failed Try again");
			return "updatePatient";
		}

		service.updatePatient(patient);
		model.addAttribute("message", "Patient Updated Successfully");
		return "profile";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/goToDelete/searchById")
	public String searchPatientToDelete(@RequestParam("patientId") String id, Model model) {
		Patient patient = service.searchPatientById(Long.parseLong(id));
		if (patient == null) {
			throw new ApplicationException("Patient Not Found");
		}
		model.addAttribute("patient", patient);
		return "deletePatient";
	}

	/**
	 * 
	 * @param patient
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deletepatient", method = RequestMethod.POST)
	private String deletePatient(@Valid @ModelAttribute("newPatient") Patient patient, BindingResult result,
			Model model) {
		service.deletePatient(patient);
		model.addAttribute("message", "Patient has been Deleted");
		return "profile";

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@ExceptionHandler(ApplicationException.class)
	public String handleException(Model model) {
		System.out.println("in exception handler of Login Controller");
		model.addAttribute("error", "Requested Patient Not Found");
		return "noPatientFound";
	}

}
