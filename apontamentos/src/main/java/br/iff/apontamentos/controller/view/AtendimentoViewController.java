package br.iff.apontamentos.controller.view;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.iff.apontamentos.service.AtendimentoService;
import br.iff.apontamentos.service.EquipamentoService;



@Controller
@RequestMapping(path = "/atendimento")
public class AtendimentoViewController {
	
	@Autowired
	AtendimentoService service;
	
	@Autowired
	EquipamentoService equipamentoService;
	
	
	@GetMapping(path = "/home")
	public String telaAtendimentos() {
		return "Atendimento/home";
	}
	
	@PostMapping(path = "cadastro")
	public String novoAtendimento(Model model, @RequestParam(name = "numeroEquipamento") int numeroEquipamento) {
		
		model.addAttribute("equipamento", equipamentoService.buscarPorNumero(numeroEquipamento));
		
		return "Atendimento/cadastro";
	}
	
	@GetMapping(path = "atendimentos/consultaratendimento")
	public String consultarAtendimento() {
		return "Atendimento/consultar";
	}
	
	@PostMapping(path = "novo")
	@ResponseStatus(HttpStatus.CREATED)
	public String novoAtendimento(
			Model model,
			@RequestParam(name = "equipamento") int numeroEquipamento,
			@RequestParam(name = "numero") int numero,
			@RequestParam(name = "data") LocalDate data){
			model.addAttribute("equipamento", equipamentoService.buscarPorNumero(numeroEquipamento));
			service.novoAtendimento(numeroEquipamento, numero, data);					
		return "Atendimento/cadastro";
	}
	
	@PostMapping(path = "listar")
	public String listarAtendimento(
			Model model,
			@RequestParam(name = "numeroEquipamento") int numeroEquipamento) {
		model.addAttribute("equipamento", equipamentoService.buscarPorNumero(numeroEquipamento));
		model.addAttribute("atendimentos", service.listarAtendimentosPorEquipamento(numeroEquipamento));
		
		return "Atendimento/listaPorEquipamento";
	}
	
	@PostMapping(path = "/delete")
	public String apagarAtendimento(
			Model model,
			@RequestParam(name = "id") Long id,
			@RequestParam(name = "numero")int numero, 
			@RequestParam(name = "numeroEquipamento") int numeroEquipamento) {
		service.deleteByNumero(id, numero, numeroEquipamento);
		model.addAttribute("equipamento", equipamentoService.buscarPorNumero(numeroEquipamento));
		model.addAttribute("atendimentos", service.listarAtendimentosPorEquipamento(numeroEquipamento));		
		return "Atendimento/listaPorEquipamento";
	}
	
	
	
	
	

}
