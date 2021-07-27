package com.example.formcomplex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

@Entity
public class Anexo {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
    private String nome;
    private String tipo;
    @Lob
    private byte[] dados;
    @ManyToOne
    private Documento documento;
    
    public Anexo() {
		// TODO Auto-generated constructor stub
	}
    
    public Anexo(String nome, String tipo, byte[] dados, Documento documento) {
		this.nome = nome;
		this.tipo = tipo;
		this.dados = dados;
		this.documento = documento;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte[] getDados() {
		return dados;
	}

	public void setDados(byte[] dados) {
		this.dados = dados;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
    
	
}
