package br.com.cq.servico;

import java.util.List;

import br.com.cq.dominio.FiltroAssunto;
import br.com.cq.dominio.dto.AssuntoDTO;

public interface IAssuntoService {

	AssuntoDTO criar(AssuntoDTO assuntoDTO);

	void remover(String id);

	AssuntoDTO editar(String id);

	List<AssuntoDTO> listar(FiltroAssunto filtro);
	
	List<AssuntoDTO> listarTodos();

}
