package br.iff.apontamentos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int prefixo;
	private String placa;
	private String modelo;
	private int odometro;
	
	public veiculo (int prefixo) {
		this.prefixo = prefixo;
	}
	
	
	public int getPrefixo() {
		return prefixo;
	}
	public void setPrefixo(int prefixo) {
		this.prefixo = prefixo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getOdometro() {
		return odometro;
	}
	public void setOdometro(int odometro) {
		this.odometro = odometro;
	}
	
	

}
