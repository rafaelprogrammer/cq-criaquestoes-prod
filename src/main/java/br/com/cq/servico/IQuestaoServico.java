package br.com.cq.servico;

import java.util.List;

import br.com.cq.dominio.FiltroQuestao;
import br.com.cq.dominio.dto.QuestaoDTO;

public interface IQuestaoServico {

	 QuestaoDTO criar(QuestaoDTO questaoDTO);
	 
	 void remover(String id);
	 
	 QuestaoDTO editar(String id);
	 
	 List<QuestaoDTO> listar(FiltroQuestao filtro);
	 
	 List<QuestaoDTO> listarTodos();
	 
}
