package com.orangetalents.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer Id;
	 private String nome;
	 private String email;
	 private String cpf;
	 
	 
	 @OneToMany
	 @JoinColumn(name = "carro_id" )
	 private List<Carro> carros = new ArrayList<>();
	 
	 private Date dataNascimento;

	 
	public Usuario() {};
	 
	public Usuario(Integer id, String nome, String email, String cpf, List<Carro> carros, Date dataNascimento) {
		Id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.carros = carros;
		this.dataNascimento = dataNascimento;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Carro> getCarros() {
		return carros;
	}
	  
}
