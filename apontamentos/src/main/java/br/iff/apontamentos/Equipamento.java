package br.iff.apontamentos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Equipamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Número obrigatório")
	@Column(unique=true)
	@Min(0)
	private int numero;
	
	@OneToOne
	@NotNull(message = "Veículo obrigatório")
	private Veiculo veiculo;
	
	@NotNull(message = "Regime obrigatório")
	@Min(0)
	private int regime;
	
	@NotNull(message = "Tipo obrigatório")
	@Size(max = 20)
	@Pattern(regexp = "^[^\\s]+$", message = "Não é permitido espaço em branco")
	private String tipo;
	
	@NotNull(message = "Area obrigatório")
	@Size(max = 20)
	@Pattern(regexp = "^[^\\s]+$", message = "Não é permitido espaço em branco")
	private String area;
	
	@OneToMany
	private List<Atendimento> atendimentos = new ArrayList<>();
	
	public Equipamento () {
		
	}
	
	public Equipamento (int numero, Veiculo veiculo, int regime, String tipo, String area) {
		this.numero = numero;
		this.veiculo = veiculo;
		this.regime = regime;
		this.tipo = tipo;
		this.area = area;
	}
	
	public void adicionarAtendimento(Atendimento atendimento) {
		this.atendimentos.add(atendimento);
	}
	
	public void removerAtendimento(Atendimento atendimento) {
		this.atendimentos.remove(atendimento);
	}
	
	public List<Atendimento> obterAtendimentos(){
		return Collections.unmodifiableList(this.atendimentos);
	}
	
	public void alterarCadastro(Veiculo veiculo, int regime, String tipo, String area) {
		this.veiculo=veiculo;
		this.regime = regime;
		this.tipo = tipo;
		this.area = area;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
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

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}
	
	

	
}
