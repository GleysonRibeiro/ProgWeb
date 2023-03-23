package br.iff.apontamentos.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.iff.apontamentos.Equipamento;
import br.iff.apontamentos.service.EquipamentoService;

@Controller
@RequestMapping(path = "/equipamento")
public class EquipamentoViewController {
	
	@Autowired
	private EquipamentoService service;
	
	@GetMapping(path = "/{id}")
	public String buscarEquipamento(@PathVariable("id") Long id, Model model) {
		//model.addAttribute("equipamento", equipamentosRepository.findById(id));
		return "formEquipamento";
	}
	@GetMapping(path = "/cadastrarequipamento")
	public String cadastrarEquipamento() {
		return "cadastroEquipamento";
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Equipamento> novoEquipamento(
			@RequestParam(name = "numero") int numero,
			@RequestParam(name = "prefixo") int prefixo,
			@RequestParam(name = "regime") int regime,
			@RequestParam(name = "tipo") String tipo,
			@RequestParam(name = "area") String area){
		
					
		return service.novoEquipamento(numero, prefixo, regime, tipo, area);
	}
	@GetMapping(path = "/home")
	public String homeEquipamento() {
		return "homeEquipamentos";
	}
	@GetMapping(path = "/apontamento")
	public String apontamento() {
		return "apontamento";
	}

}
