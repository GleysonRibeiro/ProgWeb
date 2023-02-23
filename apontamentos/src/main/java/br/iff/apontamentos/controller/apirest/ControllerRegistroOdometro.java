package br.iff.apontamentos.controller.apirest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.iff.apontamentos.RegistroOdometro;

@RestController
@RequestMapping(path = "/apirest/registroodometro")

public class ControllerRegistroOdometro {
	
	@GetMapping("/{id}")
    public String page(@PathVariable("id") int id) {
		return "Olá Mundo" + id;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String newRegistroOdometro(
			@RequestParam(name = "registroodometro") int odometro)
	{
		@SuppressWarnings("unused")
		RegistroOdometro novoDeslocamento = new RegistroOdometro();
		
		return "Deslocamento criado:";
	}
	
	@PutMapping("/{id}")
	public String atualizarDeslocamento(
			@RequestParam(name = "odometroInicial") int odometroInicial,
			@RequestParam(name = "odometroFinal") int odometroFinal){
		
		return odometroInicial + " " + odometroFinal;	
	}
	
	@DeleteMapping("/{id}")
	public String deletarDeslocamento(@RequestParam(name="id") int id) {
		return "Deslocamento deletado:" + id;
	}

}
