package br.iff.apontamentos.controller.apirest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.iff.apontamentos.Atendimento;


@RestController
@RequestMapping(path = "/apirest/atendimento")


public class ControllerAtendimento {
	
	@GetMapping("/{id}")
    public String page(@PathVariable("id") int id) {
		return "Olá Mundo" + id;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String newAtendimento(
			@RequestParam(name = "numero") int numero,
			@RequestParam(name = "data") String data
	) {
		@SuppressWarnings("unused")
		Atendimento novoAtendimento = new Atendimento(numero, data);
		
		return "Atendimento:" + numero + data;
	}
	
	@PutMapping("/{id}")
	public String atualizarAtendimento(
			@RequestParam(name = "numero") int numero, 
			@RequestParam(name= "data") String data,
			@RequestParam(name= "kmRodado") int kmRodado,
			@RequestParam(name= "horaExtra") double horaExtra,
			@RequestParam(name= "qtdPassageiros") int qtdPassageiros){
						
		
		return "Atendimento atualizado:" + numero;	
	}
	
	@DeleteMapping("/{id}")
	public String deletarAtendimento(@RequestParam(name="numero") int numero) {
		return "Atendimento deletado:" + numero;
	}
	
	

}
