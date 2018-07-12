package br.com.cq.seguranca.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.cq.seguranca.dominio.User;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(final String userName);
}
