package br.com.cq.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.cq.dominio.Resposta;

public interface RespostaRepositorio extends MongoRepository<Resposta, String> {

}
