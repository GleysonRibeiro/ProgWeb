package br.iff.apontamentos.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.iff.apontamentos.Veiculo;
import br.iff.apontamentos.repository.VeiculoRepository;


@RestController
@RequestMapping(path = "/apirest/veiculo")

public class ControllerVeiculo {
	
	@Autowired
    private VeiculoRepository veiculos;

	@GetMapping("/{id}")
    public String page(@PathVariable("id") int id) {
		return "Olá Mundo" + id;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Veiculo> newVeiculo(
			@RequestParam(name = "prefixo") int prefixo,
			@RequestParam(name = "placa") String placa,
			@RequestParam(name = "modelo") String modelo){
		
		Veiculo novoVeiculo = new Veiculo();
		
		novoVeiculo.novoVeiculo(prefixo, placa, modelo);
		
		veiculos.save(novoVeiculo);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculo);
	}
	
	@PutMapping("/{id}")
	public String atualizarVeiculo(
			@RequestParam(name = "prefixo") int prefixo,
			@RequestParam(name = "placa") String placa, 
			@RequestParam(name= "modelo") String modelo,
			@RequestParam(name= "odometro") int odometro){
		
		return prefixo + placa + modelo + odometro;		
	}
	
	@DeleteMapping("/{id}")
	public String deletarVeiculo(@RequestParam(name="prefixo") int prefixo) {
		return "Veículo deletado:" + prefixo;
	}
	

	
}

