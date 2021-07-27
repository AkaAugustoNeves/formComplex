package com.example.formcomplex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.formcomplex.controller.dto.PessoaDto;
import com.example.formcomplex.controller.form.PessoaForm;
import com.example.formcomplex.model.Pessoa;
import com.example.formcomplex.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pr;
	
	public PessoaDto save(PessoaForm form) {
		return new PessoaDto(pr.save(new Pessoa(form.getNome(), form.getEmail())));
	}
	
	public PessoaDto buscar(Long id) {
		return new PessoaDto(pr.findById(id).get());
	}
}
