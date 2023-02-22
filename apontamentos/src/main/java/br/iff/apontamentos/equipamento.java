package br.iff.apontamentos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class equipamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int numero;
	private veiculo veiculo;
	private int regime;
	private String tipo;
	private String area;
	
	public equipamento (int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public int getRegime() {
		return regime;
	}
	public void setRegime(int regime) {
		this.regime = regime;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	
}
