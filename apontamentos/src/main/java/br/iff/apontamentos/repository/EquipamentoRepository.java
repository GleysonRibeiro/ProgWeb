package br.iff.apontamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.iff.apontamentos.Equipamento;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

	Equipamento findByNumero(int numeroEquipamento);
	
	
}
