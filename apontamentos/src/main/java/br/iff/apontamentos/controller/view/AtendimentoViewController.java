package br.iff.apontamentos.controller.view;

import java.time.LocalDate;

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

import br.iff.apontamentos.service.AtendimentoService;



@Controller
@RequestMapping(path = "/atendimento")
public class AtendimentoViewController {
	
	@Autowired
	AtendimentoService service;
	
	
	@GetMapping(path = "/home")
	public String telaAtendimentos() {
		return "Atendimento/home";
	}
	
	@GetMapping(path = "atendimentos/novoatendimento")
	public String novoAtendimento() {
		return "Atendimento/cadastro";
	}
	
	@GetMapping(path = "atendimentos/consultaratendimento")
	public String consultarAtendimento() {
		return "Atendimento/consultar";
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void novoAtendimento(
			@RequestParam(name = "equipamento") int numeroEquipamento,
			@RequestParam(name = "numero") int numero,
			@RequestParam(name = "dataInicial") LocalDate dataInicial,
			@RequestParam(name = "dataFinal") LocalDate dataFinal){
		
			service.novoAtendimento(numeroEquipamento, numero, dataInicial, dataFinal);					
		
	}
	
	@PostMapping(path = "listar")
	public String listarAtendimento(
			Model model,
			@RequestParam(name = "numeroEquipamento") int numeroEquipamento) {
		model.addAttribute("atendimentos", service.listarAtendimentosPorEquipamento(numeroEquipamento));
		
		return "Atendimento/listaPorEquipamento";
	}
	
	
	
	
	

}
