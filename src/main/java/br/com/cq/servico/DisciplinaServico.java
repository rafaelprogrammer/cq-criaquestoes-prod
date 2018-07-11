package br.com.cq.servico;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.cq.dominio.Disciplina;
import br.com.cq.dominio.FiltroDisciplina;
import br.com.cq.dominio.dto.DisciplinaDTO;
import br.com.cq.repositorio.DisciplinaRepositorio;

@Service
public class DisciplinaServico implements IDisciplinaServico {
	
	@Autowired
	private DisciplinaRepositorio disciplinaRepositorio;
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public DisciplinaDTO criar(DisciplinaDTO disciplinaDTO) {
		Disciplina disciplina = disciplinaRepositorio.save(modelMapper.map(disciplinaDTO, Disciplina.class));
		return modelMapper.map(disciplina, DisciplinaDTO.class);
	}

	@Override
	public void remover(String id) {
		disciplinaRepositorio.deleteById(id);
	}

	@Override
	public DisciplinaDTO editar(String id) {
		return modelMapper.map(disciplinaRepositorio.findById(id).get(), DisciplinaDTO.class);
	}

	@Override
	public List<DisciplinaDTO> listar(FiltroDisciplina filtro) {
		Type targetListType = new TypeToken<List<DisciplinaDTO>>() {}.getType();
		return modelMapper.map(disciplinaRepositorio.findAll(), targetListType);
	}

	@Override
	public List<DisciplinaDTO> listarTodos() {
		Type targetListType = new TypeToken<List<DisciplinaDTO>>() {}.getType();
		return modelMapper.map(disciplinaRepositorio.findAll(Sort.by("nome")), targetListType);
	}

}
