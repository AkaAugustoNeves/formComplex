package com.example.formcomplex.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pessoa {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
    private String nome;
    private String email;
    @OneToMany(mappedBy = "pessoa")
    private List<Documento> documentos = new ArrayList<Documento>();
	
    public Pessoa() {
		// TODO Auto-generated constructor stub
	}
    public Pessoa(String nome, String email) {
		this.email = email;
		this.nome = nome;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
    
}
