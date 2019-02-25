package com.example.docker.app;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.docker.domain.Servico;
import com.example.docker.domain.documento.PessoaDocumento;

import io.swagger.annotations.Api;

@Api(value = "Pessoa", tags = "Pessoa")
@RestController
@RequestMapping(value = "/api")
public class Controlador {
	
	private Logger log = org.slf4j.LoggerFactory.getLogger(Controlador.class);

	@Autowired
	private Servico servico;
	
	@GetMapping
	public String helloDocker() {
		return gerarHtml();
	}
	
	@RequestMapping(value = "/pessoa", method = RequestMethod.POST)
	public ResponseEntity<PessoaDocumento> salvar(@RequestBody PessoaDocumento pessoa){
		log.info("Salvando pessoa: {}", pessoa);
		return ResponseEntity.ok(this.servico.salvar(pessoa));
	}
	
	@RequestMapping(value = "/pessoa", method = RequestMethod.GET)
	public ResponseEntity<List<PessoaDocumento>> listarPessoas(){
		log.info("Buscando pessoa");
		return ResponseEntity.ok(this.servico.listarPessoas());
	}
	
	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletar(@PathVariable String id){
		log.info("Deletando pessoa");
		return ResponseEntity.ok(servico.deletar(id));
	}
	
	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
	public ResponseEntity<PessoaDocumento> buscarPorId(@PathVariable String id){
		log.info("Buscando pessoa por id");
		return ResponseEntity.ok(servico.buscarPorId(id));
	}
	
	protected String gerarHtml() {
		return "<h1>Seja bem vindo</h1> "
				+ "<h3>Projeto exemplo utilizando Docker, Springboot e mongoDB</h3>"
				+ "<p>GET - localhost:8080/api/bemvindo -> Boas vindas</p>"
				+ "<p>GET - localhost:8080/api/pessoas -> Retornar a lista de pessoas</p>"
				+ "<p>GET - localhost:8080/api/pessoas/{id} -> Retorna uma pessoa pelo id\n</p>"
				+ "<p>POST - localhost:8080/api/pessoas {\"nome\":\"teste\", \"sobrenome\":\"teste\"} -> salvar uma pessoa</p>"
				+ "<p>DELETE - GET - localhost:8080/api/pessoas/{id} -> Deleta uma pessoa pelo id</p>";
		
	}
}
