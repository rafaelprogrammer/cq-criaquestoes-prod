package br.com.cq.seguranca.servico;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;


public interface TokenAuthenticationService {

    Authentication authenticate(HttpServletRequest request);
}
