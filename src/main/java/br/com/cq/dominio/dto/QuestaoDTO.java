package br.com.cq.dominio.dto;

import java.util.List;

import br.com.cq.dominio.TipoQuestao;
import lombok.Data;

@Data
public class QuestaoDTO {

	private String id;
	private String enunciado;
	private TipoQuestao tipoQuestao;
	private List<OpcaoDTO> opcoes;
	private String observacao;
	private AssuntoDTO assunto;
	
}
