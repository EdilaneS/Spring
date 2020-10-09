package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

// é uma interface de repositório

public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	
	//Buscar todos pelo titulo ignorando maiuscula e min.
	public List<Postagem>findAllByTituloContainingIgnoreCase(String titulo);
	
}