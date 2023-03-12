package br.iff.apontamentos.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.iff.apontamentos.repository.EquipamentoRepository;

@Controller
@RequestMapping(path = "/equipamento")
public class EquipamentoViewController {
	
	@Autowired
	private EquipamentoRepository equipamentosRepository;
	
	@GetMapping(path = "/{id}")
	public String buscarEquipamento(@PathVariable("id") Long id, Model model) {
		model.addAttribute("equipamento", equipamentosRepository.findById(id));
		return "formEquipamento";
	}

}
