package com.reciclo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Date date;
	
	public User() {}
	
	public User(Integer id, String name, Integer adm, String email, String phone, String password, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.adm = adm;
		this.email = email;
		this.phone = phone;
		this.password = password;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
