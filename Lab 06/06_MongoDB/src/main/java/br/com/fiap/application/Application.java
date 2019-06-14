package br.com.fiap.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Pessoa;
import br.com.fiap.repository.PessoaRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = PessoaRepository.class)
public class Application implements CommandLineRunner {

	@Autowired
	public PessoaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		
		repository.save(new Pessoa("Rafael"));
		
		Endereco residencial = new Endereco("Avenida Morumbi", "SP");
		Endereco comercial = new Endereco("Avenida Paulista", "SP");
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(residencial);
		enderecos.add(comercial);
		
		repository.save(new Pessoa("Paulo", enderecos));
		repository.save(new Pessoa("Julia", enderecos));
		
		for (Pessoa pessoa : repository.findAll()) {
			System.out.println(pessoa);
		}
		System.out.println();
		
		// find by nome
		System.out.println("findByNome('Julia'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByNome("Julia"));
		System.out.println();
		
		// find by nome usando like
		System.out.println("findByNomeLike('Pa'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByNomeLike("Pa"));
		System.out.println();
	}
}
