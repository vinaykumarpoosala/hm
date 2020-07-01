package com.hms.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.beans.MasterMedicine;
import com.hms.beans.Medicine;
import com.hms.repositories.MasterMedicineRepository;

@Service
public class MedicineSerivice {
	@Autowired
	MasterMedicineRepository repository;

	/**
	 * 
	 * method to get available medicines in data base and converting into a map of
	 * medicine_name as key and medicine object ad value
	 */
	public Map<String, MasterMedicine> getMapOfAvailableMedicine() {

		Map<String, MasterMedicine> mapOfAvailableMedicine = new HashMap<>();

		Iterable<MasterMedicine> medicines = repository.findAll();
		
		medicines.forEach(medicine -> {
			mapOfAvailableMedicine.put(medicine.getMedicineName(), medicine);
		});
		return mapOfAvailableMedicine;

	}

	public void updateMedicine(Medicine medicine) {
		MasterMedicine med = repository.findByName(medicine.getName());
		System.out.println(med);
		med.setQuantity(med.getQuantity()-medicine.getQuantity());
		repository.save(med);
		
	}

}
