package br.iff.apontamentos.controller.view;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/")
public class HomeViewController {
	
	
	@GetMapping(path = "/")
	public String teste() {
			
		return "home";
	}

}
