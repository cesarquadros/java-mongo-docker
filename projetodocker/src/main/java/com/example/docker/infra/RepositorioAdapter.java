package com.example.docker.infra;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.example.docker.domain.documento.PessoaDocumento;
import com.example.docker.domain.port.Repositorio;
import com.example.docker.domain.port.ServicePort;

@Repository
public class RepositorioAdapter implements ServicePort {
	
	@Autowired
	private Repositorio repositorio;
	
	@Override
	public PessoaDocumento salvar(PessoaDocumento pessoa) {
		return this.repositorio.save(pessoa);
	}
	
	@Override
	public List<PessoaDocumento> listarPessoas(){
		return this.repositorio.findAll();
	}
	
	@Override
	public String deletar(String id) {
		PessoaDocumento pessoa = buscarPorId(id);
		
		if(ObjectUtils.isEmpty(pessoa)) {
			return null;
		}
		this.repositorio.delete(pessoa);
		return pessoa.getNome();
	}

	@Override
	public PessoaDocumento buscarPorId(String id) {
		Optional<PessoaDocumento> optionalPessoa = this.repositorio.findById(id);
		PessoaDocumento pessoa = optionalPessoa.isPresent() ? optionalPessoa.get() : null;
		return pessoa;
	}
}
