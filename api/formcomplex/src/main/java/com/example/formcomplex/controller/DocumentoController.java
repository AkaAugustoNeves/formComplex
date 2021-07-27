package com.example.formcomplex.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.formcomplex.controller.dto.AnexoDto;
import com.example.formcomplex.controller.dto.DocumentoDto;
import com.example.formcomplex.controller.form.DocumentoForm;
import com.example.formcomplex.model.Anexo;
import com.example.formcomplex.model.Documento;
import com.example.formcomplex.model.Pessoa;
import com.example.formcomplex.model.TipoDocumento;
import com.example.formcomplex.repository.PessoaRepository;
import com.example.formcomplex.repository.TipoDocumentoRepository;
import com.example.formcomplex.service.AnexoService;
import com.example.formcomplex.service.DocumentoService;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

	@Autowired
	private DocumentoService ds;
	
	@Autowired
	private TipoDocumentoRepository tdr;
	
	@Autowired
	private PessoaRepository pr;
	
	@Autowired
	private AnexoService as;
	
	@GetMapping("/{id}")
	public List<DocumentoDto> listPorPessoa(@PathVariable Long id){
		return DocumentoDto.converter(ds.buscarPorIdPessoa(id));
	}
	
	@PostMapping("/{idPessoa}")
	public DocumentoDto register(@RequestBody DocumentoForm form, @PathVariable Long idPessoa) {
		TipoDocumento tipoDocumento = tdr.findById(form.getIdTipoDocumento()).get();
		Pessoa pessoa =  pr.findById(idPessoa).get();
		return new DocumentoDto(ds.save(tipoDocumento, form.getNumero(), pessoa));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id){
		return ds.delete(id);
	}
	
	@PostMapping("/{idDocumento}/anexo")
	public List<AnexoDto> registerAnexo(@RequestBody MultipartFile[] files, @PathVariable Long idDocumento) throws IOException{
		Documento documento = ds.porId(idDocumento);
		return as.saveList(files, documento);
	}
	
	@GetMapping("/anexo/{idAnexo}")
	public  ResponseEntity<ByteArrayResource> download(@PathVariable Long idAnexo){
		return as.download(idAnexo);
	}
	
	@DeleteMapping("/anexo/{idAnexo}")
	@Transactional
	public ResponseEntity<?> deleteAnexo(@PathVariable Long idAnexo){
		return as.delete(idAnexo);
	}
	
}
