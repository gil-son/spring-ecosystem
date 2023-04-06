package com.reciclo.entities;


import java.util.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Table( name = "tb_users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String name;
	
	@Column(name="owner")
	private Integer adm;
	private String email; 
	private String phone;
	private String password;
	
	@OneToOne
	@JoinColumn( name = "address_id" )
	private Address address;
	
	private Date date;
	
	public User() {}
	
	
	public User(Integer id, String name, Integer adm, String email, String phone, String password, Address address, Date date) {
		this.id = id;
		this.name = name;
		this.adm = adm;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAdm() {
		return adm;
	}
	public void setAdm(Integer adm) {
		this.adm = adm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
