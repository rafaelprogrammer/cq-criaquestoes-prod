package br.com.cq.servico;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.cq.dominio.Assunto;
import br.com.cq.dominio.FiltroAssunto;
import br.com.cq.dominio.dto.AssuntoDTO;
import br.com.cq.repositorio.AssuntoRepositorio;

@Service
public class AssuntoServico implements IAssuntoService {
	
	@Autowired
	private AssuntoRepositorio assuntoRepositorio;
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public AssuntoDTO criar(AssuntoDTO assuntoDTO) {
		Assunto assunto = assuntoRepositorio.save(modelMapper.map(assuntoDTO, Assunto.class));
		return modelMapper.map(assunto, AssuntoDTO.class);
	}

	@Override
	public void remover(String id) {
		assuntoRepositorio.deleteById(id);
	}

	@Override
	public AssuntoDTO editar(String id) {
		return modelMapper.map(assuntoRepositorio.findById(id).get(), AssuntoDTO.class);
	}

	@Override
	public List<AssuntoDTO> listar(FiltroAssunto filtro) {
		Type targetListType = new TypeToken<List<AssuntoDTO>>() {}.getType();
		if (!StringUtils.isEmpty(filtro.getIdDisciplina())) {
			return modelMapper.map(assuntoRepositorio.findByDisciplinaId(filtro.getIdDisciplina()), targetListType);
		}
		return modelMapper.map(assuntoRepositorio.findAll(), targetListType);
	}

	@Override
	public List<AssuntoDTO> listarTodos() {
		Type targetListType = new TypeToken<List<AssuntoDTO>>() {}.getType();
		return modelMapper.map(assuntoRepositorio.findAll(), targetListType);
	}

}
