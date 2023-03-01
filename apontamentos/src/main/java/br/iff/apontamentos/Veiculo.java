package br.iff.apontamentos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "Prefixo obrigatório")
	private int prefixo;
  @NotNull(message = "Placa obrigatória")
	private String placa;
  @NotNull(message = "Modelo obrigatório")
	private String modelo;
	
	public Veiculo (int prefixo, String placa, String modelo) {
		this.prefixo = prefixo;
    this.placa=placa;
    this.modelo=modelo;
	}

  public void alterarCadastro (String placa){
    this.placa=placa;
  }	

}
