package br.com.cq.dominio.dto;

import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
public class RevisaoDTO {
	
	private String id;
	private String titulo;
	private List<QuestaoDTO> questoes;
	private List<RespostaDTO> respostas;
	private int totalQuestoes;
	private int totalAcertos;
	private int totalErros;
	private int porcentagemAcertos;
	private int passo;
	private boolean concluido;
	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonDeserialize(using= DateTimeDeserializer.class)
	@JsonSerialize(using=DateTimeSerializer.class)
	private DateTime dataCriacao;

}
