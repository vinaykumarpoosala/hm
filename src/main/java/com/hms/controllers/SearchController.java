package com.hms.controllers;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.hms.beans.MasterTests;
import com.hms.beans.Patient;
import com.hms.exceptions.ApplicationException;
import com.hms.repositories.MasterTestsRepository;
import com.hms.repositories.PatientRepository;
import com.hms.services.MedicineSerivice;
import com.hms.utils.FinalBilling;

@Controller
public class SearchController {

	@Autowired
	private PatientRepository repository;
	@Autowired
	MedicineSerivice medicineService;
	@Autowired
	private MasterTestsRepository mrepo;

	@GetMapping("/search")
	public String search(HttpSession session, @RequestParam("patientId") String id, Model model) {
		System.out.println("in search controller");
		System.out.println("search criteria: " + id);
		try {
			Optional<Patient> optinalEntity = repository.findById(Long.parseLong(id));

			if (null == optinalEntity) {
				System.out.println("in if condition");
				throw new ApplicationException("patient not found");
			}
			Patient patient = optinalEntity.get();
			model.addAttribute("patient", patient);
			System.out.println(patient);

			if (session.getAttribute("userType").toString().equalsIgnoreCase("pharmacist")) {
//			System.out.println("returning to pharmacist page");
//			System.out.println(medicineService.getMapOfAvailableMedicine());
				Gson gson = new Gson();

				String jsonDataForMedicine = gson.toJson(medicineService.getMapOfAvailableMedicine());

				model.addAttribute("medicineMap", medicineService.getMapOfAvailableMedicine());
				model.addAttribute("jsonDataForMedicine", jsonDataForMedicine);
				;

				return "pharmacist";
			}

			if (session.getAttribute("userType").toString().equalsIgnoreCase("diagnostic")) {
				System.out.println("returning to pharmacist page");

				List<MasterTests> masterTests = (List<MasterTests>) mrepo.findAll();

				model.addAttribute("masterTests", masterTests);
				System.out.println(masterTests);
				return "diagnostics";
			}
			if (session.getAttribute("userType").toString().equalsIgnoreCase("executive")) {
				model.addAttribute("mapForBilling", FinalBilling.finalBilling(patient));
				System.out.println("returning to billing page");
				return "finalbilling";
			}
		} catch (Exception e) {

			throw new ApplicationException("patient not found");

		}
		return "search";
	}

	@ExceptionHandler(ApplicationException.class)
	public String handleException(Model model) {
		System.out.println("in exception handler of Login Controller");
		model.addAttribute("error", "No patient found");
		return "noPatientFound";
	}

}
