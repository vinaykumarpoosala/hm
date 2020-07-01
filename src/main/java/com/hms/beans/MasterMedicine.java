package com.hms.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MASTERMEDICINE")
public class MasterMedicine {

	@Id
	private int id;
	
	private int quantity;
	
	private int price;
	
	@Column(name = "NAME")
	private String medicineName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MasterMedicine [id=" + id + ", quantity=" + quantity + ", price=" + price + ", medicineName="
				+ medicineName + "]";
	}

	
	
}
