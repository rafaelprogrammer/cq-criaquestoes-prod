package br.com.cq.seguranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cq.seguranca.dominio.dto.UserDTO;
import br.com.cq.seguranca.servico.UserService;


@RestController
@RequestMapping("/cp/signup")
@CrossOrigin(origins="http://localhost:3000")
public class SignUpController {

    private final UserService service;

    @Autowired
    public SignUpController(final UserService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@RequestBody final UserDTO dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
    }
}
