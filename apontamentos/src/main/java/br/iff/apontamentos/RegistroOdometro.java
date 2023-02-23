package br.iff.apontamentos;

import java.time.LocalDate;
import java.time.LocalTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RegistroOdometro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDate dataInicial;
	private LocalTime horaInicial;
	private LocalDate dataFinal;
	private LocalTime horaFinal;
	private int odometroInicial;
	private int odometroFinal;
	
	
	public RegistroOdometro() {
		
	}
	
}
	

