package com.example.formcomplex.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.formcomplex.model.Anexo;

public class AnexoDto {
	private Long id;
	private String nome;
	private String tipo;
	public AnexoDto() {
		// TODO Auto-generated constructor stub
	}	
	public AnexoDto(Anexo anexo) {
		this.id = anexo.getId();
		this.nome = anexo.getNome();
		this.tipo = anexo.getTipo();
	}

	public static List<AnexoDto> converter (List<Anexo> anexos){
		return anexos.stream().map(AnexoDto::new).collect(Collectors.toList());
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
