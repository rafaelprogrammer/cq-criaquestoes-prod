package br.com.cq.servico;

import java.util.List;

import br.com.cq.dominio.FiltroDisciplina;
import br.com.cq.dominio.dto.DisciplinaDTO;

public interface IDisciplinaServico {

	DisciplinaDTO criar(DisciplinaDTO disciplinaDTO);

	void remover(String id);

	DisciplinaDTO editar(String id);

	List<DisciplinaDTO> listar(FiltroDisciplina filtro);
	
	List<DisciplinaDTO> listarTodos();

}
