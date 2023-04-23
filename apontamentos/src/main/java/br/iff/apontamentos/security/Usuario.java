package br.iff.apontamentos.security;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String username;
	
	private String password;
	
	@ManyToMany
	private List<Role> roles = new ArrayList<>();
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Usuario(String username, String password, Role role) {
		this.username =  username;
		this.password = password;
		this.roles.add(role);
	}
	
	public Usuario() {
		
	}
}
