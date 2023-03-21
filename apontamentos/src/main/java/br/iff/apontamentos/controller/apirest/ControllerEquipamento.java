package br.iff.apontamentos.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.iff.apontamentos.repository.EquipamentoRepository;
import br.iff.apontamentos.repository.VeiculoRepository;
import br.iff.apontamentos.service.EquipamentoService;

@RestController
@RequestMapping(path = "/apirest/equipamento")

public class ControllerEquipamento {
	
	
	@Autowired
	private EquipamentoService service;
	
	@GetMapping("/{id}")
    public String page(@PathVariable("id") int id) {
		return "Olá Mundo" + id;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String cadastrarEquipamento(
			@RequestParam(name = "numero") int numero,
			@RequestParam(name = "prefixo") int prefixo,
			@RequestParam(name = "regime") int regime,
			@RequestParam(name = "tipo") String tipo,
			@RequestParam(name = "area") String area)
	{	
		
		service.novoEquipamento(numero, prefixo, regime, tipo, area);
		
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
