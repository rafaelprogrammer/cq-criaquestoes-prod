package br.com.cq.dominio.dto;

import org.joda.time.DateTime;

import lombok.Data;

@Data
public class RespostaDTO {

	private String id;
	private QuestaoDTO questao;
	private OpcaoDTO opcao;
	private DateTime dataResposta;
	
}
