package com.example.formcomplex.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.formcomplex.controller.dto.AnexoDto;
import com.example.formcomplex.model.Anexo;
import com.example.formcomplex.model.Documento;
import com.example.formcomplex.repository.AnexoRepository;

@Service
public class AnexoService {
	
	@Autowired
	private AnexoRepository ar;

	public List<AnexoDto> saveList(MultipartFile[] files, Documento Documento) throws IOException{
		List<AnexoDto> anexos = new ArrayList<AnexoDto>();
		for(MultipartFile file: files) {
			anexos.add(this.save(file, Documento));
		}	
		
		return anexos;
	}
	
	public AnexoDto save(MultipartFile file, Documento documento) throws IOException {
		try {
			return new AnexoDto(ar.save(new Anexo(file.getOriginalFilename(), file.getContentType(), file.getBytes(), documento)));
		}catch (Exception e) {
			return null;
		}
	}
	
	public Anexo porId(Long id) {
		return ar.findById(id).get();
	}

	
	public ResponseEntity<ByteArrayResource> download(Long id){
		Anexo anexo = this.porId(id);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(anexo.getTipo()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= "+anexo.getNome())
				.body(new ByteArrayResource(anexo.getDados()));
	}

	public ResponseEntity<?> delete(Long idAnexo) {
		if (ar.findById(idAnexo).isPresent()) {
			ar.deleteById(idAnexo);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}	
