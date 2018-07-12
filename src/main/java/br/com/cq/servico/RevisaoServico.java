package br.com.cq.servico;

import java.lang.reflect.Type;
import java.util.List;

import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.cq.dominio.FiltroRevisao;
import br.com.cq.dominio.Questao;
import br.com.cq.dominio.Revisao;
import br.com.cq.dominio.dto.RevisaoDTO;
import br.com.cq.repositorio.QuestaoRepositorio;
import br.com.cq.repositorio.RevisaoRepositorio;

@Service
public class RevisaoServico implements IRevisaoServico {
	
	@Autowired
	private RevisaoRepositorio revisaoRepositorio;
	
	@Autowired
	private RespostaServico respostaServico;
	
	@Autowired
	private QuestaoRepositorio questaoRepositorio;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public void criar(FiltroRevisao filtro) {
		Revisao.RevisaoBuilder revisao = Revisao.builder();
		List<Questao> questoes = null;
		if (!StringUtils.isEmpty(filtro.getIdDisciplina())) {
			questoes = questaoRepositorio.findByDisciplinaId(filtro.getIdDisciplina());
		}
		if (!StringUtils.isEmpty(filtro.getIdAssunto())) {
			questoes = questaoRepositorio.findByAssuntoId(filtro.getIdAssunto());
		}
		revisaoRepositorio.save(revisao
				.titulo(filtro.getTitulo())
				.questoes(questoes)
				.dataCriacao(DateTime.now())
				.totalQuestoes(questoes.size())
				.build());
	}
	
	@Override
	public void atualizar(RevisaoDTO revisaoDTO) {
		Revisao revisao = modelMapper.map(revisaoDTO, Revisao.class);
		if (revisao.getRespostas() != null && !revisao.getRespostas().isEmpty()) {
			revisao.setRespostas(respostaServico.salvarAtualizarRespostas(revisao.getRespostas()));
		}
		if(revisao.getQuestoes().size() == revisao.getRespostas().size()) {
			revisao.setConcluido(true);
		}
		revisao.setTotalAcertos(0);
		revisao.setTotalErros(0);
		revisao.getRespostas().stream().forEach(r -> {
			if(r.getOpcao().isCorreta()) {
				revisao.setTotalAcertos(revisao.getTotalAcertos() + 1);
			} else {
				revisao.setTotalErros(revisao.getTotalErros() + 1);
			}
		});
		revisao.setPorcentagemAcertos(Math.round((revisao.getTotalAcertos() * 100) / revisao.getTotalQuestoes()));
		revisaoRepositorio.save(revisao);
	}

	@Override
	public void remover(String id) {
		revisaoRepositorio.deleteById(id);
	}

	@Override
	public RevisaoDTO editar(String id) {
		return modelMapper.map(revisaoRepositorio.findById(id).get(), RevisaoDTO.class);
	}

	@Override
	public List<RevisaoDTO> listar(FiltroRevisao filtro) {
		Type targetListType = new TypeToken<List<RevisaoDTO>>() {}.getType();
		return modelMapper.map(revisaoRepositorio.findAll(), targetListType);
	}

	@Override
	public List<RevisaoDTO> listarTodos() {
		Type targetListType = new TypeToken<List<RevisaoDTO>>() {}.getType();
		return modelMapper.map(revisaoRepositorio.findAll(), targetListType);
	}

}
