package br.iff.apontamentos;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "deslocamentos")
public class RegistroOdometro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dataInicial;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime horaInicial;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dataFinal;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime horaFinal;
	private int odometroInicial;
	private int odometroFinal;
	
	
	
	public RegistroOdometro() {
		
	}
	
	
	
}
	

