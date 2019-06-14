package br.com.fiap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.entity.Pessoa;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {

	public Pessoa findByNome(String nome);
	
	public Pessoa findByNomeLike(String nome);
	
}
