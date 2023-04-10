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
import br.iff.apontamentos.service.VeiculoService;

@Controller
@RequestMapping(path = "/equipamento")
public class EquipamentoViewController {
	
	@Autowired
	private EquipamentoService service;
	
	@Autowired
	private VeiculoService veiculoService;
	
	
	@GetMapping(path = "/cadastro")
	public String cadastrarEquipamento(Model model) {
		
		model.addAttribute("veiculos", veiculoService.findAll());
		
		return "Equipamento/cadastro";
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String novoEquipamento(
			@RequestParam(name = "numero") int numero,
			@RequestParam(name = "prefixo") int prefixo,
			@RequestParam(name = "regime") int regime,
			@RequestParam(name = "tipo") String tipo,
			@RequestParam(name = "area") String area){
			service.novoEquipamento(numero, prefixo, regime, tipo, area);
					
		return "apontamento";
	}
	@GetMapping(path = "/home")
	public String homeEquipamento() {
		return "Equipamento/home";
	}
	
	@PostMapping("/listarAtendimentos")
    public String listarAtendimentos(@RequestParam("numeroEquipamento") int numeroEquipamento, Model model) {
		
		Equipamento equipamento = service.buscarPorNumero(numeroEquipamento);
		
		model.addAttribute("atendimentos", equipamento.obterAtendimentos());
		
		return "atendimentos";
	}
	
	
}
