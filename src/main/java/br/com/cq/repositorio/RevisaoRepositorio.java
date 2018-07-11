package br.com.cq.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.cq.dominio.Revisao;

public interface RevisaoRepositorio extends MongoRepository<Revisao, String> {

}
