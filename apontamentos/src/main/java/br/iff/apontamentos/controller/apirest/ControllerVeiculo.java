package br.iff.apontamentos.controller.apirest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/apirest/veiculo")

public class ControllerVeiculo {

	@GetMapping("/{id}")
    public String page(@PathVariable("id") int id) {
		return "Olá Mundo" + id;
	}   
	
}

