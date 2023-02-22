package br.iff.apontamentos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Atendimento {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int numero;
	//private equipamento equipamento;
	private String data;
	private int kmRodado;
	private double horaExtra;
	private int qtdPassageiros;
	private int odometroIni;
	private int odometroFim;
	
	public Atendimento(int numero, String data) {
		
		this.numero = numero;
		this.data = data;		
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getKmRodado() {
		return kmRodado;
	}
	public void setKmRodado(int kmRodado) {
		this.kmRodado = kmRodado;
	}
	public double getHoraExtra() {
		return horaExtra;
	}
	public void setHoraExtra(double horaExtra) {
		this.horaExtra = horaExtra;
	}
	public int getQtdPassageiros() {
		return qtdPassageiros;
	}
	public void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}
	public int getOdometroIni() {
		return odometroIni;
	}
	public void setOdometroIni(int odometroIni) {
		this.odometroIni = odometroIni;
	}
	public int getOdometroFim() {
		return odometroFim;
	}
	public void setOdometroFim(int odometroFim) {
		this.odometroFim = odometroFim;
	}
	
	

}
