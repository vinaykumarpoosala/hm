package com.hms.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.beans.MasterTests;
import com.hms.repositories.MasterTestsRepository;

@Service
public class MasterTestsService {

	@Autowired
	private MasterTestsRepository repository;
	/**
	 * 
	 * @return available tests in database
	 */
	public Map<String ,Integer> availableTests()
	{
		Map<String, Integer> mapOfAvailableTests = new HashMap<>();

		
	Iterable<MasterTests> masterTests =  repository.findAll();
	masterTests.forEach(test -> {
		mapOfAvailableTests.put(test.getTestName(), test.getRate());
	});
	
	return mapOfAvailableTests;
	}

	
}

