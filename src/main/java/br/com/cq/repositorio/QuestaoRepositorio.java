package br.com.cq.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.cq.dominio.Questao;

public interface QuestaoRepositorio extends MongoRepository<Questao, String> {

	public List<Questao> findByAssuntoId(String id);
	
	public List<Questao> findByDisciplinaId(String id);
	
}
