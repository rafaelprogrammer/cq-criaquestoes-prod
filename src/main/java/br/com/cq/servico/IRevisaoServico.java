package br.com.cq.servico;

import java.util.List;

import br.com.cq.dominio.FiltroRevisao;
import br.com.cq.dominio.dto.RevisaoDTO;

public interface IRevisaoServico {

	void criar(FiltroRevisao filtro);
	
	void atualizar(RevisaoDTO revisaoDTO);
	
	void remover(String id);

	RevisaoDTO editar(String id);

	List<RevisaoDTO> listar(FiltroRevisao filtro);
	
	List<RevisaoDTO> listarTodos();
	
}
