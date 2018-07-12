package br.com.cq.seguranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cq.seguranca.dominio.dto.LoginDTO;
import br.com.cq.seguranca.dominio.dto.TokenDTO;
import br.com.cq.seguranca.servico.TokenService;


@RestController
@RequestMapping("/cp/auth")
@CrossOrigin(origins="http://localhost:3000")
public class AuthenticationController {

    private final TokenService tokenService;

    @Autowired
    public AuthenticationController(final TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody final LoginDTO dto) {
        final String token = tokenService.getToken(dto.getUsername(), dto.getPassword());
        if (token != null) {
            final TokenDTO response = new TokenDTO();
            response.setToken(token);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authentication failed", HttpStatus.BAD_REQUEST);
        }
    }
}
