package com.example.docker.domain.port;

import java.util.List;

import com.example.docker.domain.documento.PessoaDocumento;

public interface ServicePort {
	
	PessoaDocumento salvar(PessoaDocumento pessoa);
	List<PessoaDocumento> listarPessoas();
	String deletar(String id);
	PessoaDocumento buscarPorId(String id);
}
