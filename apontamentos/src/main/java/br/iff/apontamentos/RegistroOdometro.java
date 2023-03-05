package br.iff.apontamentos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
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
	
	
	
	public RegistroOdometro() {
		
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
		
}
	

