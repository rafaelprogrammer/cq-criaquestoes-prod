package br.com.cq.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cq.dominio.Resposta;
import br.com.cq.repositorio.RespostaRepositorio;

@Service
public class RespostaServico implements IRespostaServico {
	
	@Autowired
	private RespostaRepositorio repostaRepositorio;
	
	@Override
	public List<Resposta> salvarAtualizarRespostas(List<Resposta> respostas) {
		return repostaRepositorio.saveAll(respostas);
	}

	@Override
	public boolean removerRespostas(List<Resposta> respostas) {
		repostaRepositorio.deleteAll(respostas);
		return true;
	}

}
