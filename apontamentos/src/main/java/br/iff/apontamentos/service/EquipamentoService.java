package br.iff.apontamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.iff.apontamentos.Atendimento;
import br.iff.apontamentos.Equipamento;
import br.iff.apontamentos.Veiculo;
import br.iff.apontamentos.repository.EquipamentoRepository;

@Service
public class EquipamentoService {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private EquipamentoRepository repo;
	
	public ResponseEntity<Equipamento> novoEquipamento(int numero, int prefixo, int regime, String tipo, String area) {
		Veiculo veiculo = veiculoService.findByPrefixo(prefixo);
		Equipamento novoEquipamento = new Equipamento(numero, veiculo, regime, tipo, area);		
		
		this.repo.save(novoEquipamento);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(novoEquipamento);
	}
	
	public List<Equipamento> listarEquipamentos(){
		List<Equipamento> equipamentos = repo.findAll();
		return equipamentos;		
	}
	
	
	public Equipamento buscarPorNumero(int numeroEquipamento){
		Equipamento equipamento = repo.findByNumero(numeroEquipamento);
		
		return equipamento;
	}
	
	public List<Atendimento> buscarAtendimentosPorNumero(int numeroEquipamento){
		Equipamento equipamento = repo.findByNumero(numeroEquipamento);
		
		return equipamento.obterAtendimentos();
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);		
	}
	
	public void adicionarAtendimento(int numeroEquipamento, Atendimento atendimento) {
		Equipamento equipamentoAlterado = this.buscarPorNumero(numeroEquipamento);
		equipamentoAlterado.adicionarAtendimento(atendimento);
		this.repo.save(equipamentoAlterado);
	}
	
	public void removerAtendimento(int numeroEquipamento, Atendimento atendimento) {
		Equipamento equipamentoAlterado = this.buscarPorNumero(numeroEquipamento);
		equipamentoAlterado.removerAtendimento(atendimento);
		this.repo.save(equipamentoAlterado);
	}
}
