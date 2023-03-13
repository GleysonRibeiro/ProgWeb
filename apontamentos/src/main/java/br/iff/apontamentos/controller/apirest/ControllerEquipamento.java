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
import br.iff.apontamentos.Equipamento;
import br.iff.apontamentos.Veiculo;

@RestController
@RequestMapping(path = "/apirest/equipamento")

public class ControllerEquipamento {
	
	@GetMapping("/{id}")
    public String page(@PathVariable("id") int id) {
		return "Olá Mundo" + id;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String newEquipamento(
			@RequestParam(name = "numero") int numero)
	{
		Equipamento novoEquipamento = new Equipamento();
		novoEquipamento.novoEquipamento(numero);
		
		return "Equipamento:" + numero;
	}
	
	@PutMapping("/{id}")
	public String atualizarEquipamento(
			@RequestParam(name = "numero") int numero,
			@RequestParam(name = "veiculo") Veiculo veiculo, 
			@RequestParam(name= "regime") int regime,
			@RequestParam(name= "tipo") String tipo,
			@RequestParam(name= "area") String area){
		
		return numero + regime + tipo + area;		
	}
	
	@DeleteMapping("/{id}")
	public String deletarEquipamento(@RequestParam(name="numero") int numero) {
		return "Equipamento deletado:" + numero;
	}

}
