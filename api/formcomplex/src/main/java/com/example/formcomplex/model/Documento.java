package com.example.formcomplex.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Documento {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
	@ManyToOne
	private TipoDocumento tipoDocumento;
	private String numero;
	@OneToMany(mappedBy = "documento")
	private List<Anexo> anexos = new ArrayList<Anexo>();
	@ManyToOne
	private Pessoa pessoa;
	
	public Documento() {
		// TODO Auto-generated constructor stub
	}
	public Documento(TipoDocumento tipo, String numero, Pessoa pessoa) {
		this.tipoDocumento = tipo;
		this.numero = numero;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Anexo> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
