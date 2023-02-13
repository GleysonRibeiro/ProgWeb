package br.iff.apontamentos.controller.apirest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.iff.apontamentos.veiculo;

@RestController
@RequestMapping(path = "/apirest/veiculo")

public class ControllerVeiculo {

	@GetMapping("/{id}")
    public String page(@PathVariable("id") int id) {
		return "Olá Mundo" + id;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String newVeiculo(
			@RequestParam(name = "prefixo") int prefixo)
	{
		@SuppressWarnings("unused")
		veiculo novoVeiculo = new veiculo(prefixo);
		
		return "Veiculo:" + prefixo;
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

