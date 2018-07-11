package br.com.cq.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.cq.dominio.Disciplina;
@Repository
public interface DisciplinaRepositorio extends MongoRepository<Disciplina, String> {

}
