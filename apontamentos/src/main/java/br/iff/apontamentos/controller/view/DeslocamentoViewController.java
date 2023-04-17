package br.iff.apontamentos.controller.view;


import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.iff.apontamentos.repository.DeslocamentoRepository;
import br.iff.apontamentos.service.AtendimentoService;
import br.iff.apontamentos.service.DeslocamentoService;
import br.iff.apontamentos.service.EquipamentoService;



@Controller
@RequestMapping(path = "/deslocamento")
public class DeslocamentoViewController {
	
	@Autowired
	private DeslocamentoService service;
	
	@Autowired
	private AtendimentoService serviceAtendimento;
	
	@Autowired
	private EquipamentoService serviceEquipamento;
	
	@PostMapping(path = "listar")
	public String listarDeslocamentos(
			Model model, 
			@RequestParam(name ="numeroAtendimento")int numeroAtendimento,
			@RequestParam(name ="numeroEquipamento")int numeroEquipamento) {
		model.addAttribute("deslocamentos", service.listarDeslocamentosPorAtendimento(numeroAtendimento));
		model.addAttribute("equipamento", serviceEquipamento.buscarPorNumero(numeroEquipamento));
		model.addAttribute("atendimento", serviceAtendimento.findByNumero(numeroAtendimento));
		return "Deslocamento/lista";
	}
	@PostMapping(path = "novo")
	public String novoDeslocamento(
			Model model, 
			@RequestParam(name ="numeroAtendimento")int numeroAtendimento,
			@RequestParam(name ="numeroEquipamento")int numeroEquipamento) {
		model.addAttribute("atendimento", serviceAtendimento.findByNumero(numeroAtendimento));
		model.addAttribute("equipamento", serviceEquipamento.buscarPorNumero(numeroEquipamento));
		return "Deslocamento/cadastro";
	}
	
	@PostMapping(path = "inserir")
	public String inserirDeslocamento(
			Model model, 
			@RequestParam(name ="dataInicial")LocalDate dataIncial,
			@RequestParam(name ="horaInicial")LocalTime horaInicial,
			@RequestParam(name ="dataFinal")LocalDate dataFinal,
			@RequestParam(name ="horaFinal")LocalTime horaFinal,
			@RequestParam(name ="odometroInicial")int odometroInicial,
			@RequestParam(name ="odometroFinal")int odometroFinal,
			@RequestParam(name ="numeroAtendimento")int numeroAtendimento,
			@RequestParam(name ="numeroEquipamento")int numeroEquipamento) {
		
		service.inserirDeslocamento(numeroAtendimento, dataIncial, horaInicial, dataFinal, horaFinal, odometroInicial, odometroFinal);
		
		model.addAttribute("deslocamentos", service.listarDeslocamentosPorAtendimento(numeroAtendimento));
		model.addAttribute("equipamento", serviceEquipamento.buscarPorNumero(numeroEquipamento));
		model.addAttribute("atendimento", serviceAtendimento.findByNumero(numeroAtendimento));
		
		return "Deslocamento/lista";
	}
	
	@PostMapping(path ="delete")
	public String apagarDeslocamento(
			Model model,
			@RequestParam(name ="idDeslocamento")Long id,
			@RequestParam(name ="numeroAtendimento")int numeroAtendimento,
			@RequestParam(name ="numeroEquipamento")int numeroEquipamento) {
		
		service.apagarDeslocamento(id, numeroAtendimento);
		model.addAttribute("deslocamentos", service.listarDeslocamentosPorAtendimento(numeroAtendimento));
		model.addAttribute("atendimento", serviceAtendimento.findByNumero(numeroAtendimento));
		model.addAttribute("equipamento", serviceEquipamento.buscarPorNumero(numeroEquipamento));
		return "Deslocamento/lista";
	}

}
