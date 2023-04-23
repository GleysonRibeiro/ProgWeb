package br.iff.apontamentos.controller.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import br.iff.apontamentos.service.VeiculoService;


@Controller
@RequestMapping(path = "/veiculo")
public class VeiculoViewController {
	
	@Autowired
	VeiculoService service;
	
	@GetMapping(path = "/cadastro")
	public String homeVeiculo() {
		
		return "Veiculo/cadastro";
	}
	
	@PostMapping(path = "/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public String novoVeiculo(
			@RequestParam(name = "prefixo") int prefixo,
			@RequestParam(name = "placa") String placa,
			@RequestParam(name = "modelo") String modelo){
			
			service.novoVeiculo(prefixo, placa, modelo);
		
		return "Veiculo/cadastro";
	}
	
	@GetMapping(path = "/listar")
	public String listarVeiculos(Model model){
		
		model.addAttribute("veiculos", service.findAll());
		return "Veiculo/home";
	}
	
	@PostMapping(path = "/delete")
	public String apagarVeiculo(Model model, @RequestParam(name = "id")Long id) {
		service.deleteById(id);
		model.addAttribute("veiculos", service.findAll());
		return "Veiculo/home";
	}

}
