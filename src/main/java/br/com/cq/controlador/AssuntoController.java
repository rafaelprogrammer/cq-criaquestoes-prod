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

import br.com.cq.dominio.FiltroAssunto;
import br.com.cq.dominio.dto.AssuntoDTO;
import br.com.cq.servico.IAssuntoService;

@RestController
@RequestMapping("/assunto")
@CrossOrigin(origins="http://localhost:3000")
public class AssuntoController {
	
	@Autowired
	private IAssuntoService assuntoService;
	
	
	@PostMapping
	public void criar(@RequestBody AssuntoDTO assuntoDTO) {
		assuntoService.criar(assuntoDTO);
	}
	
	@PutMapping
	public void atualizar(@RequestBody AssuntoDTO assuntoDTO) {
		assuntoService.criar(assuntoDTO);
	}
	
	@GetMapping("/listarTodos")
	public ResponseEntity<List<AssuntoDTO>> listarTodos() {
		return ResponseEntity.ok(assuntoService.listarTodos());
	}
	
	@PostMapping("/listar")
	public ResponseEntity<List<AssuntoDTO>> listarTodos(@RequestBody FiltroAssunto filtro) {
		return ResponseEntity.ok(assuntoService.listar(filtro));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AssuntoDTO> editar(@PathVariable(name="id") String id) {
		return ResponseEntity.ok(assuntoService.editar(id));
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable(name="id") String id) {
		assuntoService.remover(id);
	}
}
