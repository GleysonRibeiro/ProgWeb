package br.iff.apontamentos;

import java.time.LocalDate;

import java.time.LocalTime;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Min;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "deslocamentos")
public class Deslocamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInicial;
	
	private LocalTime horaInicial;	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataFinal;
	
	private LocalTime horaFinal;
	
	@Min(0)
	private int odometroInicial;
	
	@Min(0)
	private int odometroFinal;
	
	
	
	public Deslocamento() {
		
	}
	
	public Deslocamento(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, LocalTime horaFinal, int odometroInicial, int odometroFinal) {
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.odometroInicial = odometroInicial;
		this.odometroFinal = odometroFinal;		
		
	}
	
	public int deslocar(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, LocalTime horaFinal, int odometroInicial, int odometroFinal) {
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.odometroInicial = odometroInicial;
		this.odometroFinal = odometroFinal;
		
		return this.odometroFinal - this.odometroInicial;		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalTime getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(LocalTime horaInicial) {
		this.horaInicial = horaInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(LocalTime horaFinal) {
		this.horaFinal = horaFinal;
	}

	public int getOdometroInicial() {
		return odometroInicial;
	}

	public void setOdometroInicial(int odometroInicial) {
		this.odometroInicial = odometroInicial;
	}

	public int getOdometroFinal() {
		return odometroFinal;
	}

	public void setOdometroFinal(int odometroFinal) {
		this.odometroFinal = odometroFinal;
	}
	
	
		
}
	

