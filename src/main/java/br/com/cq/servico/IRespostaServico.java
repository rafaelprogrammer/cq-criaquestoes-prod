package br.com.cq.servico;

import java.util.List;

import br.com.cq.dominio.Resposta;

public interface IRespostaServico {
	 List<Resposta> salvarAtualizarRespostas(List<Resposta> respostas);
	 boolean removerRespostas(List<Resposta> respostas);
}
