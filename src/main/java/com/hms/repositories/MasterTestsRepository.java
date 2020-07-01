package com.hms.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hms.beans.MasterTests;

@Repository
public interface MasterTestsRepository extends CrudRepository<MasterTests, Integer> {

}
