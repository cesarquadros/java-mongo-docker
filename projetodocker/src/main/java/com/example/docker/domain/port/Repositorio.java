package com.example.docker.domain.port;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.docker.domain.documento.PessoaDocumento;

@Repository
public interface Repositorio extends MongoRepository<PessoaDocumento, String>{

}
