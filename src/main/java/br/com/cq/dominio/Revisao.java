package br.com.cq.dominio;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Document
public class Revisao {
	
	@Id
	private String id;
	private String titulo;
	private List<Questao> questoes;
	private List<Resposta> respostas;
	private int totalQuestoes;
	private int totalAcertos;
	private int totalErros;
	private int porcentagemAcertos;
	private int passo;
	private boolean concluido;
	private DateTime dataCriacao;
	
	public Revisao() {
	}

	@Builder
	public Revisao(String id, String titulo, List<Questao> questoes, List<Resposta> respostas, int totalQuestoes,
			int totalAcertos, int totalErros, int porcentagemAcertos, int passo, boolean concluido,
			DateTime dataCriacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.questoes = questoes;
		this.respostas = respostas;
		this.totalQuestoes = totalQuestoes;
		this.totalAcertos = totalAcertos;
		this.totalErros = totalErros;
		this.porcentagemAcertos = porcentagemAcertos;
		this.passo = passo;
		this.concluido = concluido;
		this.dataCriacao = dataCriacao;
	}
	
	

}
