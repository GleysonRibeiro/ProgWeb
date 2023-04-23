package br.iff.apontamentos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(path = "/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	@PostMapping(path = "/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public String novoUsuario(
			@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password,
			@RequestParam(name = "role") String role){
			
			service.adicionarUsuario(username, password, role);
		
		return "home";
	}

}
