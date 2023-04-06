package com.reciclo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table( name = "tb_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String zipCode;
	private Integer publicPlace;
	private String complement; 
	private String district;
	private String locality;
	private String State;
	private Integer number;
	
	public Address() {}
	
	public Address(Integer id, String zipCode, Integer publicPlace, String complement, String district, String locality,
			String state, Integer number) {
		
		this.id = id;
		this.zipCode = zipCode;
		this.publicPlace = publicPlace;
		this.complement = complement;
		this.district = district;
		this.locality = locality;
		State = state;
		this.number = number;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Integer getPublicPlace() {
		return publicPlace;
	}
	public void setPublicPlace(Integer publicPlace) {
		this.publicPlace = publicPlace;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
