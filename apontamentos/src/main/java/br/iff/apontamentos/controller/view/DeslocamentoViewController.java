package br.iff.apontamentos.controller.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.iff.apontamentos.repository.DeslocamentoRepository;



@Controller
@RequestMapping(path = "/registroodometro")
public class DeslocamentoViewController {
	
	@Autowired
	private DeslocamentoRepository deslocamentosRepository;
	
	@GetMapping(path = "/{id}")
	public String buscarRegistroOdometro(@PathVariable("id") Long id, Model model) {
		model.addAttribute("registroodometro", deslocamentosRepository.findById(id));
		return "formRegistroOdometro";
	}

}
