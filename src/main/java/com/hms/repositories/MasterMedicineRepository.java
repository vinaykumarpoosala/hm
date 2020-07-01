package com.hms.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hms.beans.MasterMedicine;

@Repository
public interface MasterMedicineRepository extends CrudRepository<MasterMedicine, Integer>{
	@Query("select u from MasterMedicine u where u.medicineName= :name")
	MasterMedicine findByName(@Param("name") String name);
	
}
