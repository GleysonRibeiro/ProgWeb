package br.iff.apontamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import br.iff.apontamentos.Deslocamento;

@Repository
public interface DeslocamentoRepository extends JpaRepository<Deslocamento, Long> {

}
