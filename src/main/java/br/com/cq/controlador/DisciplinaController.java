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

import br.com.cq.dominio.dto.DisciplinaDTO;
import br.com.cq.servico.IDisciplinaServico;

@RestController
@RequestMapping("/disciplina")
@CrossOrigin(origins="http://localhost:3000")
public class DisciplinaController {
	
	@Autowired
	private IDisciplinaServico disciplinaServico;
	
	
	@PostMapping
	public void criar(@RequestBody DisciplinaDTO disciplinaDTO) {
		disciplinaServico.criar(disciplinaDTO);
	}
	
	@PutMapping
	public void atualizar(@RequestBody DisciplinaDTO disciplinaDTO) {
		disciplinaServico.criar(disciplinaDTO);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<DisciplinaDTO>> listarTodos() {
		return ResponseEntity.ok(disciplinaServico.listarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DisciplinaDTO> editar(@PathVariable(name="id") String id) {
		return ResponseEntity.ok(disciplinaServico.editar(id));
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable(name="id") String id) {
		disciplinaServico.remover(id);
	}
}
