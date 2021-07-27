package com.example.formcomplex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.formcomplex.controller.dto.PessoaDto;
import com.example.formcomplex.controller.form.PessoaForm;
import com.example.formcomplex.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService ps;
	
	@PostMapping()
	public PessoaDto criar(@RequestBody PessoaForm form) {
		return ps.save(form);		
	}
	
	@GetMapping("/{id}")
	public PessoaDto buscar(@PathVariable Long id) {
		return ps.buscar(id);
	}
	
}
