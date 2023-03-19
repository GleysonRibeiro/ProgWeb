package br.iff.apontamentos.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.iff.apontamentos.repository.AtendimentoRepository;

@Controller
@RequestMapping(path = "/atendimentos")
public class AtendimentoViewController {
	
	@Autowired
	private AtendimentoRepository atendimentosRepository;
	
	@GetMapping(path = "/home")
	public String telaAtendimentos() {
		return "homeAtendimentos";
	}
	
	@GetMapping(path = "atendimentos/novoatendimento")
	public String novoAtendimento() {
		return "cadastroAtendimentos";
	}
	
	@GetMapping(path = "atendimentos/consultaratendimento")
	public String consultarAtendimento() {
		return "consultarAtendimentos";
	}
	
	@GetMapping(path = "/{id}")
	public String buscarAtendimento(@PathVariable("id") Long id, Model model) {
		model.addAttribute("atendimento", atendimentosRepository.findById(id));
		return "formAtendimento";
	}
	
	
	

}
