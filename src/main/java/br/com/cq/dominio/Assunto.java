package br.com.cq.dominio;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Assunto {
	
	@Id
	private String id;
	private String descricao;
	private Disciplina disciplina;
	
	public Assunto() {
	}

	public Assunto(String descricao, Disciplina disciplina) {
		super();
		this.descricao = descricao;
		this.disciplina = disciplina;
	}

}
