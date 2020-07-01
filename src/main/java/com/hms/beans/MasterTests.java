package com.hms.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//JPA


@Entity
@Table(name = "MASTERTESTS")
public class MasterTests {

	@Id
	private int id;
	
	@Column(name = "test_name")
	private String testName;
	
	private int rate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "MasterTests [id=" + id + ", testName=" + testName + ", rate=" + rate + "]";
	}
	
	
}
