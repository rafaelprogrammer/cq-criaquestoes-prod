package br.com.cq.servico;

import java.lang.reflect.Type;
import java.util.List;

import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.cq.dominio.FiltroQuestao;
import br.com.cq.dominio.Questao;
import br.com.cq.dominio.dto.QuestaoDTO;
import br.com.cq.repositorio.QuestaoRepositorio;

@Service
public class QuestaoServico implements IQuestaoServico {
	
	@Autowired
	private QuestaoRepositorio questaoRepositorio;
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public QuestaoDTO criar(QuestaoDTO questaoDTO) {
		Questao questao = modelMapper.map(questaoDTO, Questao.class);
		if (StringUtils.isEmpty(questaoDTO.getId())) {
			questao.setDataCriacao(DateTime.now());
		} else {
			questao.setDataAlteracao(DateTime.now());
		}
		questao = questaoRepositorio.save(questao);
		return modelMapper.map(questao, QuestaoDTO.class);
	}

	@Override
	public void remover(String id) {
		questaoRepositorio.deleteById(id);
	}

	@Override
	public QuestaoDTO editar(String id) {
		return modelMapper.map(questaoRepositorio.findById(id).get(), QuestaoDTO.class);
	}

	@Override
	public List<QuestaoDTO> listar(FiltroQuestao filtro) {
		Type targetListType = new TypeToken<List<QuestaoDTO>>() {}.getType();
		return modelMapper.map(questaoRepositorio.findAll(), targetListType);
	}

	@Override
	public List<QuestaoDTO> listarTodos() {
		Type targetListType = new TypeToken<List<QuestaoDTO>>() {}.getType();
		return modelMapper.map(questaoRepositorio.findAll(), targetListType);
	}

}
