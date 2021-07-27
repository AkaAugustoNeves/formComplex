package com.example.formcomplex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.formcomplex.model.Documento;
import com.example.formcomplex.model.Pessoa;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

	List<Documento> findByPessoa(Pessoa pessoa);
	
}
