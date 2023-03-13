package br.iff.apontamentos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;


@Entity
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Número obrigatório")
	@Column(unique=true)
	@Min(0)
	private int numero;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
    
	@Min(1)
	private int kmRodado;
	
	@Min(0)
	private double horaExtra;
	
	@Min(0)
	private int qtdPassageiros;
	
	@OneToMany
	private List<RegistroOdometro> deslocamentos = new ArrayList<>();
	
	public Atendimento() {
		
	}
	
	public void novoAtendimento(int numero, LocalDate data) {
		
		this.numero = numero;
		this.data = data;
		this.kmRodado=0;
	}
	
	public void adicionarDeslocamento(RegistroOdometro deslocamento) {
		this.deslocamentos.add(deslocamento);
	}
	
	public List<RegistroOdometro> obterDeslocamentos(){
		return Collections.unmodifiableList(deslocamentos);
	}
	
	public void registrarAvulso(double horaExtra, int pax) {
		this.horaExtra = horaExtra;
		this.qtdPassageiros = pax;
	}
	
	public void deslocar(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, LocalTime horaFinal, int odometroInicial, int odometroFinal) {
		
		RegistroOdometro deslocamento = new RegistroOdometro();
		this.kmRodado += deslocamento.deslocar(dataInicial, dataFinal, horaInicial, horaFinal, odometroInicial, odometroFinal);
		this.adicionarDeslocamento(deslocamento);
	}
	

}
