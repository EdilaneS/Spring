package com.minhaescola.controller;

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

import com.minhaescola.model.AlunoModel;
import com.minhaescola.repository.AlunoRepository;



@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@GetMapping // Seleciona todos os itens da lista alunos
	public ResponseEntity<List<AlunoModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<AlunoModel>GetById(@PathVariable Long id){
		return repository.findById(id).
				map(resp ->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public AlunoModel postAluno (@RequestBody AlunoModel aluno) {
		repository.save(aluno);
		return aluno;
		
	}
	
	
	@PutMapping("/aluno/{id}")
	public AlunoModel putAluno (@PathVariable Long id, @RequestBody AlunoModel aluno) {
		aluno.setId(id);
		repository.save(aluno);
		return aluno;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
	
	


