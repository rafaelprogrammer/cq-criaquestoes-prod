package br.com.cq.seguranca.servico;


public interface TokenService {

    String getToken(String username, String password);
}
