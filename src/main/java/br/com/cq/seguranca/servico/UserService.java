package br.com.cq.seguranca.servico;

import java.util.List;

import br.com.cq.seguranca.dominio.User;
import br.com.cq.seguranca.dominio.dto.UserDTO;


public interface UserService {

	UserDTO create(UserDTO userDTO);

    User find(String id);

    User findByUsername(String userName);

    List<User> findAll();

    User update(String id, User object);

    String delete(String id);
}
