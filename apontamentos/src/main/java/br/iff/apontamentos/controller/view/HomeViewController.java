package br.iff.apontamentos.controller.view;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import br.iff.apontamentos.service.EquipamentoService;



@Controller
@RequestMapping(path = "/")
public class HomeViewController {
	
	@Autowired
	EquipamentoService equipamentoService;
	
	
	@GetMapping(path = "/")
	public String home() {
			
		return "home";
	}
	@GetMapping(path = "/apontamento")
	public String abrirApontamento(Model model) {
		
		model.addAttribute("equipamentos", equipamentoService.listarEquipamentos());
		
	    return "apontamento";
	}
	
}
