package br.iff.apontamentos.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public int novoEquipamento(int numero, int prefixo, int regime, String tipo, String area) {
		Veiculo veiculo = veiculoService.findByPrefixo(prefixo);
		Equipamento novoEquipamento = new Equipamento(numero, veiculo, regime, tipo, area);		
		
		this.repo.save(novoEquipamento);
		
		return 1;
	}

}
