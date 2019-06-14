package br.com.fiap.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Pessoa {
	
	@Id
    private String id;
    private String nome;
    private List<Endereco> endereco;
 
    public Pessoa() {}
    
    public Pessoa(String nome) {
        this.nome = nome;
    }
    
    public Pessoa(String nome, List<Endereco> endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}

	@Override
    public String toString() {
    	return "ID: " + id + " - Nome: " + nome + "\nEndereco: " + endereco;
    }

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setAddress(List<Endereco> endereco) {
		this.endereco = endereco;
	}

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
}
