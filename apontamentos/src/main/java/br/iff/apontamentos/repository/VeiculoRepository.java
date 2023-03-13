package br.iff.apontamentos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.iff.apontamentos.Veiculo;


@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	

}
