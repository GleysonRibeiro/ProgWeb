package br.iff.apontamentos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private RoleService roleService;
	
	public void adicionarUsuario(String username, String password, String role) {
		Role roleRecuperada = roleService.findByName(role);
		Usuario novoUsuario = new Usuario(username, password, roleRecuperada);
		repo.save(novoUsuario);		
	}
	
	public void excluirUsuario(String username) {
		Usuario usuario = repo.findByUsername(username);
		repo.delete(usuario);
	}

}
