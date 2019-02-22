package com.example.docker.domain;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.docker.domain.documento.PessoaDocumento;
import com.example.docker.domain.port.ServicePort;

@Service
public class Servico {

	@Autowired
	private ServicePort servico;
	
	public PessoaDocumento salvar(PessoaDocumento pessoa) {
		return this.servico.salvar(pessoa);
	}
	
	public List<PessoaDocumento> listarPessoas(){
		return this.servico.listarPessoas();
	}
	
	public String deletar(String id) {
		return this.servico.deletar(id);
	}
	
	public PessoaDocumento buscarPorId(String id) {
		return this.servico.buscarPorId(id);
	}
}
