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

import br.com.cq.dominio.FiltroRevisao;
import br.com.cq.dominio.dto.RevisaoDTO;
import br.com.cq.servico.IRevisaoServico;

@RestController
@RequestMapping("/revisao")
@CrossOrigin(origins="http://localhost:3000")
public class RevisaoController {
	
	@Autowired
	private IRevisaoServico revisaoServico;
	
	
	@PostMapping
	public void criar(@RequestBody FiltroRevisao filtro) {
		revisaoServico.criar(filtro);
	}
	
	@PutMapping
	public void atualizar(@RequestBody RevisaoDTO revisaoDTO) {
		revisaoServico.atualizar(revisaoDTO);
	}
	
	@GetMapping("/listarTodos")
	public ResponseEntity<List<RevisaoDTO>> listarTodos() {
		return ResponseEntity.ok(revisaoServico.listarTodos());
	}
	
	@PostMapping("/listar")
	public ResponseEntity<List<RevisaoDTO>> listarTodos(@RequestBody FiltroRevisao filtro) {
		return ResponseEntity.ok(revisaoServico.listar(filtro));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RevisaoDTO> editar(@PathVariable(name="id") String id) {
		return ResponseEntity.ok(revisaoServico.editar(id));
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable(name="id") String id) {
		revisaoServico.remover(id);
	}
}
