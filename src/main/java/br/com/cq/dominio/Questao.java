package br.com.cq.dominio;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Questao {

	@Id
	private String id;
	private String enunciado;
	private TipoQuestao tipoQuestao;
	private List<Opcao> opcoes;
	private String observacao;
	private DateTime dataCriacao;
	private DateTime dataAlteracao;
	@DBRef
	private Assunto assunto;
	
}
