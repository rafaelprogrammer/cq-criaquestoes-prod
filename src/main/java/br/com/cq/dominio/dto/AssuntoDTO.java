package br.com.cq.dominio.dto;

import lombok.Data;

@Data
public class AssuntoDTO {
	
	private String id;
	private String descricao;
	private DisciplinaDTO disciplina;
	
}
