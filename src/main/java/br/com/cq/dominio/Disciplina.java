package br.com.cq.dominio;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Disciplina {

	@Id
	private String id;
	private String nome;
	
	public Disciplina() {
	}
	
	private Disciplina(String nome) {
		super();
		this.nome = nome;
	}
	
	public static Disciplina criar(String nome) {
		return new Disciplina(nome);
	}

}
