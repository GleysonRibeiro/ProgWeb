package br.iff.apontamentos.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.iff.apontamentos.Deslocamento;
import br.iff.apontamentos.repository.DeslocamentoRepository;

@Service
public class DeslocamentoService {
	
	@Autowired
	DeslocamentoRepository repo;
	
	@Autowired
	AtendimentoService atendimentoService;
	
	public List<Deslocamento> listarDeslocamentosPorAtendimento(int numeroAtendimento){
		return atendimentoService.listarDeslocamentos(numeroAtendimento);		
	}
	
	public void inserirDeslocamento(int numeroAtendimento, LocalDate dataInicial, LocalTime horaInicial, LocalDate dataFinal, LocalTime horaFinal, int odometroInicial, int odometroFinal) {
		Deslocamento novoDeslocamento = new Deslocamento(dataInicial, dataFinal, horaInicial, horaFinal, odometroInicial, odometroFinal);
		repo.save(novoDeslocamento);
		atendimentoService.adicionarDeslocamento(novoDeslocamento, numeroAtendimento);
		
	}
	
	public void apagarDeslocamento(Long id, int numeroAtendimento) {
		Deslocamento deslocamento = repo.getById(id);
		atendimentoService.apagarDeslocamento(deslocamento, numeroAtendimento);
		repo.delete(deslocamento);
		
	}

}
