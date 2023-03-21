package br.iff.apontamentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.iff.apontamentos.Veiculo;
import br.iff.apontamentos.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repo;
	
	
	public ResponseEntity<Veiculo> novoVeiculo(int prefixo, String placa, String modelo){
		
		Veiculo novoVeiculo = new Veiculo(prefixo, placa, modelo);
						
		repo.save(novoVeiculo);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculo);
	}
	
	
	public Veiculo findByPrefixo(int prefixo) {
		
		Veiculo veiculo = repo.findByPrefixo(prefixo);
		
		return veiculo;
	}
	

}
