package br.iff.apontamentos.controller.apirest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.iff.apontamentos.Atendimento;
import br.iff.apontamentos.repository.AtendimentoRepository;


@RestController
@RequestMapping(path = "/apirest/atendimento")
@Service

public class ControllerAtendimento {
	@Autowired
	private AtendimentoRepository repositorio;
	
	@GetMapping("/{id}")
    public String page(@PathVariable("id") int id) {
		return "Olá Mundo" + id;
	}
	
	@GetMapping(path = "/")
	public String atendimentoCriado() {
		
		return "homeAtendimentos";
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String novoAtendimento(
			@ModelAttribute Atendimento novoAtendimento,
			@RequestParam(name = "numero") int numero,
			@RequestParam(name = "dataInicial") LocalDate dataInicial,
			@RequestParam(name = "dataFinal") LocalDate dataFinal
			
	) {
		
		LocalDate dataAtual = dataInicial;		
		
		while (!dataAtual.isAfter(dataFinal)) {
			novoAtendimento = new Atendimento(numero, dataAtual);			
			repositorio.save(novoAtendimento);
			dataAtual = dataAtual.plusDays(1);
		}
		
		
		return "/atendimentos/home";
	}
	
	@PutMapping("/{id}")
	public String atualizarAtendimento(
			@RequestParam(name = "numero") int numero, 
			@RequestParam(name= "data") LocalDate data,
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
