package br.iff.apontamentos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.iff.apontamentos.Atendimento;
import br.iff.apontamentos.Equipamento;
import br.iff.apontamentos.repository.AtendimentoRepository;

@Service
public class AtendimentoService {
	
	@Autowired
	private AtendimentoRepository repo;
	
	@Autowired
	private EquipamentoService equipamentoService;
	
	public int novoAtendimento(int numeroEquipamento, int numero, LocalDate dataInicial, LocalDate dataFinal) {
		LocalDate dataAtual = dataInicial;
		Atendimento novoAtendimento;
		Equipamento equipamento = equipamentoService.buscarPorNumero(numeroEquipamento);
		if(equipamento==null) {
			throw new RuntimeException("O equipamento não foi localizado");
		}
				
		while (!dataAtual.isAfter(dataFinal)) {
			novoAtendimento = new Atendimento(numero, dataAtual);			
			this.repo.save(novoAtendimento);
			equipamento.adicionarAtendimento(novoAtendimento);
			dataAtual = dataAtual.plusDays(1);
		}
		return 1;
	}
	
	public List<Atendimento> listarAtendimentos() {
		return repo.findAll();	
	}
	
	public List<Atendimento> listarAtendimentosPorEquipamento(int numEquipamento) {
		
		return equipamentoService.buscarAtendimentosPorNumero(numEquipamento);	
	}

}
