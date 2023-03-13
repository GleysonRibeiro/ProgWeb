package br.iff.apontamentos.controller.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.iff.apontamentos.repository.VeiculoRepository;


@Controller
@RequestMapping(path = "/veiculo")
public class VeiculoViewController {
	
	@Autowired
	private VeiculoRepository veiculosRepository;
	
	@GetMapping(path = "/{id}")
	public String buscarVeiculo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("veiculo", veiculosRepository.findById(id));
		return "formVeiculo";
	}

}
