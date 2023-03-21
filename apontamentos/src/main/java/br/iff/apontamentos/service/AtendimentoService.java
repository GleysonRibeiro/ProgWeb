package br.iff.apontamentos.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.iff.apontamentos.Atendimento;
import br.iff.apontamentos.repository.AtendimentoRepository;

@Service
public class AtendimentoService {
	
	@Autowired
	private AtendimentoRepository repo;
	
	public int novoAtendimento(int numero, LocalDate dataInicial, LocalDate dataFinal) {
		LocalDate dataAtual = dataInicial;
		Atendimento novoAtendimento;
				
		while (!dataAtual.isAfter(dataFinal)) {
			novoAtendimento = new Atendimento(numero, dataAtual);			
			this.repo.save(novoAtendimento);
			dataAtual = dataAtual.plusDays(1);
		}
		return 1;
	}

}
