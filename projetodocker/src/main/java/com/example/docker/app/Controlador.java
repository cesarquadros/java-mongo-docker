package com.example.docker.app;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.docker.domain.Servico;
import com.example.docker.domain.documento.PessoaDocumento;

@RestController
@RequestMapping("/api/pessoa")
public class Controlador {
	
	private Logger log = org.slf4j.LoggerFactory.getLogger(Controlador.class);

	@Autowired
	private Servico servico;
	
	@PostMapping
	public ResponseEntity<PessoaDocumento> salvar(@RequestBody PessoaDocumento pessoa){
		log.info("Salvando pessoa: {}", pessoa);
		return ResponseEntity.ok(this.servico.salvar(pessoa));
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaDocumento>> listarPessoas(){
		log.info("Buscando pessoa");
		return ResponseEntity.ok(this.servico.listarPessoas());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable String id){
		log.info("Deletando pessoa");
		return ResponseEntity.ok(servico.deletar(id));
	}
}
