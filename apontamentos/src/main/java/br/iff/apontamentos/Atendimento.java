package br.iff.apontamentos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;


import javax.validation.constraints.NotNull;


@Entity
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Número obrigatório")
	@Min(0)
	private int numero;
	
	@NotNull(message = "Data obrigatória")	
	private LocalDate data;
    
	private int kmRodado;
	
	@Min(0)
	private double horaExtra;
	
	@Min(0)
	private int qtdPassageiros;
	
	@OneToMany
	private List<Deslocamento> deslocamentos = new ArrayList<>();
	
	public Atendimento() {
		
	}
	
	public Atendimento(int numero, LocalDate data) {
		this.numero = numero;
		this.data = data;
		this.kmRodado=0;
		this.qtdPassageiros=0;
		this.horaExtra=0;
	}
	
	public void adicionarDeslocamento(Deslocamento deslocamento) {
		this.deslocamentos.add(deslocamento);
	}
	
	public void apagarDeslocamento(Deslocamento deslocamento) {
		this.deslocamentos.remove(deslocamento);
	}
	
	public List<Deslocamento> obterDeslocamentos(){
		return Collections.unmodifiableList(deslocamentos);
	}
	
	public void registrarAvulso(double horaExtra, int pax) {
		this.horaExtra = horaExtra;
		this.qtdPassageiros = pax;
	}
	
	public void deslocar(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, LocalTime horaFinal, int odometroInicial, int odometroFinal) {
		
		Deslocamento deslocamento = new Deslocamento();
		this.kmRodado += deslocamento.deslocar(dataInicial, dataFinal, horaInicial, horaFinal, odometroInicial, odometroFinal);
		this.adicionarDeslocamento(deslocamento);
	}
	
	public LocalDate getData() {
		return this.data;
	}
	
	public int getNumero() {
		return this.numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKmRodado() {
		return kmRodado;
	}

	public void setKmRodado(int kmRodado) {
		this.kmRodado += kmRodado;
	}
	
	public void removeKmRodado(int km) {
		this.kmRodado = this.kmRodado-km;
	}

	public double getHoraExtra() {
		return horaExtra;
	}

	public void setHoraExtra(double horaExtra) {
		this.horaExtra += horaExtra;
	}

	public int getQtdPassageiros() {
		return qtdPassageiros;
	}

	public void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros += qtdPassageiros;
	}

	public List<Deslocamento> getDeslocamentos() {
		return deslocamentos;
	}

	public void setDeslocamentos(List<Deslocamento> deslocamentos) {
		this.deslocamentos = deslocamentos;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	

}
