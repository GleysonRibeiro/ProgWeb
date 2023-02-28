package br.iff.apontamentos;

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
	//@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private String data;
	@Min(1)
	private int kmRodado;
	@Min(0)
	private double horaExtra;
	@Min(0)
	private int qtdPassageiros;
	@OneToMany
	private List<RegistroOdometro> deslocamentos = new ArrayList<>();
	
	
	public Atendimento(int numero, String data) {
		
		this.numero = numero;
		this.data = data;		
	}
	
	public void adicionarDeslocamento(RegistroOdometro deslocamento) {
		this.deslocamentos.add(deslocamento);
	}
	
	public List<RegistroOdometro> obterDeslocamentos(){
		return Collections.unmodifiableList(deslocamentos);
	}
	
	

}
