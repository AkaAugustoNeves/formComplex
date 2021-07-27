package com.example.formcomplex.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.formcomplex.model.Pessoa;

public class PessoaDto {

	
	private Long id;
	private String nome;
	private String email;
	private List<DocumentoDto> documentos;
	
	public PessoaDto(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.email= pessoa.getEmail();
		this.documentos = DocumentoDto.converter(pessoa.getDocumentos());
	}
	
	public static List<PessoaDto> converter(List<Pessoa> pessoas){
		return pessoas.stream().map(PessoaDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<DocumentoDto> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<DocumentoDto> documentos) {
		this.documentos = documentos;
	}
	
	
	
}
