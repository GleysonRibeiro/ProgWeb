package br.iff.apontamentos;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "Prefixo obrigatório")
	@Column(unique=true)
	@Min(1)
	private int prefixo;
	
	@NotNull(message = "Placa obrigatória")
	@Column(unique=true)
	@Size(min = 7, max = 7)
	@Pattern(regexp = "^[^\\s]+$", message = "Não é permitido espaço em branco")
	private String placa;
	
	@NotNull(message = "Modelo obrigatório")
	@Size(max = 20)
	private String modelo;
	
	public Veiculo() {
		
	}
	
	
	
	
	public void novoVeiculo (int prefixo, String placa, String modelo) {
		this.prefixo = prefixo;
		this.placa=placa;
		this.modelo=modelo;
	}

	public void alterarCadastro (String placa){
		this.placa=placa;
	}	

}
