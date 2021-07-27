package com.example.formcomplex.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.formcomplex.model.Documento;

public class DocumentoDto {
	private Long id;
	private String nomeTipoDocumento;
	private String numero;
	private List<AnexoDto> anexos;
	
	public DocumentoDto(Documento documento) {
		this.id = documento.getId();
		this.nomeTipoDocumento = documento.getTipoDocumento().getNome();
		this.numero = documento.getNumero();
		this.anexos = AnexoDto.converter(documento.getAnexos());
	}
	
	public static List<DocumentoDto> converter(List<Documento> documentos){
		return documentos.stream().map(DocumentoDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeTipoDocumento() {
		return nomeTipoDocumento;
	}

	public void setNomeTipoDocumento(String nomeTipoDocumento) {
		this.nomeTipoDocumento = nomeTipoDocumento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<AnexoDto> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<AnexoDto> anexos) {
		this.anexos = anexos;
	}
	
	
	
	
}
