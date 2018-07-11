package br.com.cq.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.cq.dominio.Assunto;

public interface AssuntoRepositorio extends MongoRepository<Assunto, String> {

	public List<Assunto> findByDisciplinaId(String id);
}
