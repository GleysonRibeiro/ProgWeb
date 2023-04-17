package br.iff.apontamentos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.iff.apontamentos.Atendimento;
import br.iff.apontamentos.Deslocamento;
import br.iff.apontamentos.Equipamento;
import br.iff.apontamentos.repository.AtendimentoRepository;

@Service
public class AtendimentoService {
	
	@Autowired
	private AtendimentoRepository repo;
	
	@Autowired
	private EquipamentoService equipamentoService;
	
	public void novoAtendimento(int numeroEquipamento, int numero, LocalDate data) {
		
		if(equipamentoService.buscarPorNumero(numeroEquipamento)==null) {
			throw new RuntimeException("O equipamento não foi localizado");
		}
		Atendimento novoAtendimento = new Atendimento(numero, data);				
		this.repo.save(novoAtendimento);
		this.equipamentoService.adicionarAtendimento(numeroEquipamento, novoAtendimento);
	
	}
	
	public List<Atendimento> listarAtendimentos() {
		return repo.findAll();	
	}
	
	public List<Atendimento> listarAtendimentosPorEquipamento(int numEquipamento) {
		
		return equipamentoService.buscarAtendimentosPorNumero(numEquipamento);	
	}
	
	public void deleteByNumero(Long id, int numero, int numeroEquipamento) {
		Atendimento atendimento = this.repo.findByNumero(numero);
		this.equipamentoService.removerAtendimento(numeroEquipamento, atendimento);
		repo.deleteById(id);		
	}
	
	public List<Deslocamento> listarDeslocamentos(int numeroAtendimento){
		Atendimento atendimento = this.repo.findByNumero(numeroAtendimento);			
		return atendimento.getDeslocamentos();
	}
	
	public Atendimento findByNumero(int numero) {
		return this.repo.findByNumero(numero);	
	}
	
	public void adicionarDeslocamento(Deslocamento deslocamento, int numeroAtendimento) {
	
		Atendimento atendimento = this.findByNumero(numeroAtendimento);		
		atendimento.adicionarDeslocamento(deslocamento);
		atendimento.setKmRodado(deslocamento.getOdometroFinal()-deslocamento.getOdometroInicial());
		repo.save(atendimento);
	
	}
	
	public void apagarDeslocamento(Deslocamento deslocamento, int numeroAtendimento) {
		Atendimento atendimento = repo.findByNumero(numeroAtendimento);
		atendimento.apagarDeslocamento(deslocamento);
		int kmDeslocamento = deslocamento.getOdometroFinal()-deslocamento.getOdometroInicial();
		atendimento.removeKmRodado(kmDeslocamento);
		repo.save(atendimento);
	}

}
