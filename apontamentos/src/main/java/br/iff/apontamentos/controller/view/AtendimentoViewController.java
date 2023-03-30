package br.iff.apontamentos.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.iff.apontamentos.repository.AtendimentoRepository;

@Controller
@RequestMapping(path = "/atendimento")
public class AtendimentoViewController {
	
	
	
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
	
	
	

}
