package com.example.formcomplex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.formcomplex.model.Documento;
import com.example.formcomplex.model.Pessoa;
import com.example.formcomplex.model.TipoDocumento;
import com.example.formcomplex.repository.DocumentoRepository;
import com.example.formcomplex.repository.PessoaRepository;

@Service
public class DocumentoService {

	@Autowired
	private DocumentoRepository dr;
	
	@Autowired
	private PessoaRepository pr;
	
	public List<Documento> buscarPorIdPessoa(Long idPessoa){
		Pessoa pessoa = pr.findById(idPessoa).get();
		List<Documento> documentos = dr.findByPessoa(pessoa);
		return documentos;
	}
	
	public Documento save(TipoDocumento tipo, String numero, Pessoa pessoa) {
		return dr.save(new Documento(tipo, numero, pessoa));
	}
	
	public Documento porId(Long id) {
		return dr.findById(id).get();
	}
	
	public ResponseEntity<?> delete(Long id){
		if(dr.findById(id).isPresent()) {
			dr.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
		
	}
}
