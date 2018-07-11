package br.com.cq.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cq.dominio.dto.QuestaoDTO;
import br.com.cq.servico.IQuestaoServico;

@RestController
@RequestMapping("/questao")
@CrossOrigin(origins="http://localhost:3000")
public class QuestaoController {
	
	@Autowired
	private IQuestaoServico questaoServico;
	
	
	@PostMapping
	public void criar(@RequestBody QuestaoDTO questaoDTO) {
		questaoServico.criar(questaoDTO);
	}
	
	@PutMapping
	public void atualizar(@RequestBody QuestaoDTO questaoDTO) {
		questaoServico.criar(questaoDTO);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<QuestaoDTO>> listarTodos() {
		return ResponseEntity.ok(questaoServico.listarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<QuestaoDTO> editar(@PathVariable(name="id") String id) {
		return ResponseEntity.ok(questaoServico.editar(id));
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable(name="id") String id) {
		questaoServico.remover(id);
	}
}
