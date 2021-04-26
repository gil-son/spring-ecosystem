package com.devsuperior.domainmodel.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Annotation for JPA. This is a Entity
@Table(name= "tb_client")

public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Inform database to creat a primary key auto_increment
	private int id;
	private String name;
	private String email;
	
	public Client() {}
	
	public Client(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
