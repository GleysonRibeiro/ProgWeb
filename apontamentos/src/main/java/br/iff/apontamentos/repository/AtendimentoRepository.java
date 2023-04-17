package br.iff.apontamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.iff.apontamentos.Atendimento;


@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
	
	Atendimento findByNumero(int numeroAtendimento);

}
