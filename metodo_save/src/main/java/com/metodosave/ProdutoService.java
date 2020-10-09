package com.metodosave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@Transactional
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	public void save(Produto produto) {
		repo.save(produto);
	}
	


}