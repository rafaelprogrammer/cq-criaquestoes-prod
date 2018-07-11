package br.com.cq.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.cq.dominio.Questao;

public interface QuestaoRepositorio extends MongoRepository<Questao, String> {

	public List<Questao> findByAssuntoId(String id);
	
	@Query("{'assunto.disciplina.id': ?0}")
	public List<Questao> findByDisciplinaId(String id);
	
}
