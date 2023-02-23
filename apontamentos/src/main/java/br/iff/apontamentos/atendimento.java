package br.iff.apontamentos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int numero;
	private LocalDate data;
	private int kmRodado;
	private double horaExtra;
	private int qtdPassageiros;
	private List<RegistroOdometro> deslocamentos = new ArrayList<>();
	
	
	public Atendimento(int numero, LocalDate data) {
		
		this.numero = numero;
		this.data = data;		
	}
	
	public void adicionarDeslocamento(RegistroOdometro deslocamento) {
		this.deslocamentos.add(deslocamento);
	}
	
	public List<RegistroOdometro> obterDeslocamentos(){
		return Collections.unmodifiableList(deslocamentos);
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
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
	
	
	

}
