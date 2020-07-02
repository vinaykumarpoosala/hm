package com.hms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.beans.Diagnostic;
import com.hms.beans.Medicine;
import com.hms.beans.Patient;
import com.hms.repositories.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository repository;
	@Autowired
	MedicineSerivice medicineSerivice;

	//to add patient
	public Patient addPatient(Patient patient) {
		patient.setStatus("active");
		return repository.save(patient);
	}

	//search patient by id
	public Patient searchPatientById(Long id) {
		Patient patient = null;
		Optional<Patient> optinalEntity = repository.findById(id);
		if (optinalEntity.isPresent()) {

			patient = optinalEntity.get();
		}
		return patient;
	}

	
	//update patient
	public Patient updatePatient(Patient patient) {
		
		Patient originalP = searchPatientById(patient.getId());
		
		
		originalP.setAddress(patient.getAddress());
		originalP.setName(patient.getName());
		originalP.setAge(patient.getAge());
		originalP.setCity(patient.getCity());
		originalP.setState(patient.getState());
		originalP.setTypeOfBed(patient.getTypeOfBed());
		
		//saving original patient
		Patient p = repository.save(originalP);
		System.err.println(p);
		return p;

	}

	
	//delete patient
	public void deletePatient(@Valid Patient patient) {
		repository.delete(patient);

	}

	
	//adding medicine to patient
	public void addMedicine(String id, Medicine medicine) {
		Patient patient = searchPatientById(Long.parseLong(id));
		medicineSerivice.updateMedicine(medicine);
		patient.getMedicines().add(medicine);

		repository.save(patient);

	}

	//adding tests to the patient
	public void addTest(String id, Diagnostic diagnostic) {

		Patient patient = searchPatientById(Long.parseLong(id));

		patient.getTests().add(diagnostic);

		repository.save(patient);

	}

	//finding all active patients
	public List<Patient> findAllActivePatients() {
		List<Patient> activePatients = new ArrayList<>();
		List<Patient> patients = (List<Patient>) repository.findAll();
		System.out.println("in findall method");
		System.out.println(patients);
		for(Patient patient:patients)
		{
			System.out.println(patient);
			System.out.println("in for loop");
			if(patient.getStatus()!=null)
			{
			if(patient.getStatus().equalsIgnoreCase("active"))
			{
				System.out.println("in if condition");
				activePatients.add(patient);
			}
			}
		}
		return activePatients;
	}

}
