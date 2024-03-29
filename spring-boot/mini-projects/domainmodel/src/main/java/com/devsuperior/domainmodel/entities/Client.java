package com.devsuperior.domainmodel.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;



@Entity // Annotation for JPA. This is a Entity
@Table(name="tb_client")

public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Inform database to creat a primary key auto_increment
	private Integer id; // Interger accept null
	private String name;
	private String email;
	
	public Client() {}
	
	public Client(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
