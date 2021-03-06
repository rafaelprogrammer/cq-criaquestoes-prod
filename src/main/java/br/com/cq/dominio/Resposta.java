package br.com.cq.dominio;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Resposta {

	private String id;
	@DBRef
	private Questao questao;
	private Opcao opcao;
	private DateTime dataResposta;
	
}
