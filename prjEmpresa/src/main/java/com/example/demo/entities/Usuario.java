package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=3,message="minimo de 3 caracteres")
	private String nome;
	
	@NotNull
	@Size(min=8,message="minimo de 8 caracteres")
	private String senha;
	
	@NotNull	
	@Email(message="informe um email valido")
	private String email;

	public String getNome() {
		return nome;

	}

	public void setNome(String nome) {
		this.nome = nome;

	}

	public Long getId() {
		return id;

	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;

	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;

	}

	public void setEmail(String email) {
		this.email = email;
	}
}
