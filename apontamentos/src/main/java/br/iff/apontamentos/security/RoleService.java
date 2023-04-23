package br.iff.apontamentos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService  {
	
	@Autowired
	RoleRepository repo;
	
	public Role findByName(String name) {
		return repo.findByName(name);
	}

}
