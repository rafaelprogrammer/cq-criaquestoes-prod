package br.com.cq.seguranca.servico;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.cq.seguranca.dominio.User;
import br.com.cq.seguranca.dominio.dto.UserDTO;
import br.com.cq.seguranca.repositorio.UserRepository;


@Service
public class BasicUserService implements UserService {

    private final UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private ModelMapper modelMapper = new ModelMapper();
    
    
    @Autowired
    public BasicUserService(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDTO create(final UserDTO userDTO) {
    	User user = modelMapper.map(userDTO, User.class);
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(String.valueOf(LocalDateTime.now()));
        return modelMapper.map(repository.save(user), UserDTO.class);
    }

    @Override
    public User find(final String id) {
        return repository.findById(id).get();
    }

    @Override
    public User findByUsername(final String userName) {
        return repository.findByUsername(userName);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User update(final String id, final User user) {
        user.setId(id);

        final User saved = repository.findById(id).get();

        if (saved != null) {
            user.setCreatedAt(saved.getCreatedAt());
            user.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        } else {
            user.setCreatedAt(String.valueOf(LocalDateTime.now()));
        }
        repository.save(user);
        return user;
    }

    @Override
    public String delete(final String id) {
        repository.deleteById(id);
        return id;
    }
}
