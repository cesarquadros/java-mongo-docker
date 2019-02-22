package com.example.docker.domain.documento;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pessoa")
public class PessoaDocumento {

	@Id
	private String id;
	private String nome;
	private String sobrenome;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	@Override
	public String toString() {
		return "PessoaDocumento [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + "]";
	}
}
