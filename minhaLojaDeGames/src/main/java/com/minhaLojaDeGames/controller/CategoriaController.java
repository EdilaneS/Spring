package com.minhaLojaDeGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minhaLojaDeGames.model.CategoriaModel;
import com.minhaLojaDeGames.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	@GetMapping
	public ResponseEntity<List<CategoriaModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/{descricao}")
	public ResponseEntity<List<CategoriaModel>> GetByCategoria(@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

	@PostMapping
	public CategoriaModel postCategoria(@RequestBody CategoriaModel categoria) {
		repository.save(categoria);
		return categoria;
	}

	@PutMapping
	public CategoriaModel putCategoria(@PathVariable long id, @RequestBody CategoriaModel 		categoria) {
		categoria.setId(id);
		repository.save(categoria);
		return categoria;
	}
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable long id) {
			repository.deleteById(id);
		}
	
}

