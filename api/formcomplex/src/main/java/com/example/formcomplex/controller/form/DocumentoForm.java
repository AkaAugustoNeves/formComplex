package com.example.formcomplex.controller.form;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class DocumentoForm {

	public Long idTipoDocumento;
	public String numero;
	
	public DocumentoForm() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}	
	
}
