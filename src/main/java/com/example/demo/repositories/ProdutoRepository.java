package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	@org.springframework.transaction.annotation.Transactional(readOnly= true)
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> Categorias, Pageable pageRequest);
	
}
