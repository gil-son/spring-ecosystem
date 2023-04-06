package com.orangetalents.entities;




import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "tb_carros")
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private Double Valor;
	private String Marca;
	private String Modelo;
	private Integer AnoModelo;
	private Boolean Rodizio;
	
	
	public Carro() {}
	
	public Carro(Integer id, String marca, String modelo, Integer anoModelo, Double valor, Boolean rodizio) {
		Id = id;
		Marca = marca;
		Modelo = modelo;
		AnoModelo = anoModelo;
		Valor = valor;
		Rodizio = rodizio;
	}
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Double getValor() {
		return Valor;
	}
	public void setValor(Double valor) {
		Valor = valor;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public Integer getAnoModelo() {
		return AnoModelo;
	}
	public void setAnoModelo(Integer anoModelo) {
		AnoModelo = anoModelo;
	}
	public Boolean getRodizio() {
		return Rodizio;
	}
	public void setRodizio(Boolean rodizio) {
		Rodizio = rodizio;
	}
	
}
