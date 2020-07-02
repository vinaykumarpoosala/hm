package com.hms.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hms.beans.Diagnostic;
import com.hms.beans.Medicine;
import com.hms.beans.Patient;

public final class FinalBilling {

	/**
	 * 
	 * @param patient
	 * @return
	 */
	public static Map<String, Integer> finalBilling(Patient patient) {
		String dateOfAdmission = patient.getDateoFAdmission();
		Map<String, Integer> mapForBilling = new HashMap<>();
		int billForDiagnostics = billForDiagnostics(patient);
		int billForStay = billForStay(patient);
		int billForMedicine = billForMedicine(patient);
		int totalBill = billForDiagnostics+billForStay+billForMedicine;
		mapForBilling.put("noOfDays", DateUtils.getNoOfDaysStayed(dateOfAdmission));
		mapForBilling.put("billForDaignostics", billForDiagnostics);
		mapForBilling.put("billForStay", billForStay);
		mapForBilling.put("billForMedicine", billForMedicine);
		mapForBilling.put("totalBill", totalBill);
		return mapForBilling;
	}
	

	/**
	 * 
	 * @param patient
	 * @return billForDiagnostics
	 */
	public static int billForDiagnostics(Patient patient) {
		int totalBillForDiagnostics = 0;
		List<Diagnostic> diagnostics = patient.getTests();
		for (Diagnostic diagnostic : diagnostics) {
			totalBillForDiagnostics += diagnostic.getAmount();
		}
		return totalBillForDiagnostics;
	}

	
	/**
	 * 
	 * @param patient
	 * @return total bill for stay
	 */
	public static int billForStay(Patient patient) {
		int totalbillForStay = 0;
		String dateOfAdmission = patient.getDateoFAdmission();

		int noOfDaysStayed = DateUtils.getNoOfDaysStayed(dateOfAdmission);

		if (patient.getTypeOfBed().equalsIgnoreCase("Single Room")) {
			totalbillForStay = noOfDaysStayed * 8000;
		}
		if (patient.getTypeOfBed().equalsIgnoreCase("Semi Sharing")) {
			totalbillForStay = noOfDaysStayed * 4000;
		}
		if (patient.getTypeOfBed().equalsIgnoreCase("General ward")) {
			totalbillForStay = noOfDaysStayed * 2000;
		}

		return totalbillForStay;
	}
	

	/**
	 * 
	 * @param patient
	 * @return total bill for medicine
	 */
	public static int billForMedicine(Patient patient) {
		int totalBillForMedicine = 0;
		for (Medicine medicine : patient.getMedicines()) {
			totalBillForMedicine += medicine.getAmount();
		}
		return totalBillForMedicine;
	}

}
