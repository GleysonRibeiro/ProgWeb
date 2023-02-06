package br.iff.apontamentos.controller.apirest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/apirest/equipamento")


public class ControllerAtendimento {
	
	@GetMapping("/{id}")
    public String page(@PathVariable("id") int id) {
		return "Olá Mundo" + id;
	}
	
	@PostMapping("/new")
	public String newAtendimento(
			@RequestParam(name = "nome") String nome,
			@RequestParam(name = "sobrenome") String sobrenome			
	) {
		return "Parametros:" + nome + sobrenome;
	}

}
