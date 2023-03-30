package br.iff.apontamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
	
	public ResponseEntity<List<Equipamento>> listarEquipamentos(){
		List<Equipamento> equipamentos = repo.findAll();
		return ResponseEntity.status(HttpStatus.CREATED).body(equipamentos);		
	}

}
