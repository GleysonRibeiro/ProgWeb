package br.iff.apontamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import br.iff.apontamentos.RegistroOdometro;

@Repository
public interface RegistroOdometroRepository extends JpaRepository<RegistroOdometro, Long> {

}
