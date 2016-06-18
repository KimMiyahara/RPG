package br.com.pathfinder.api.service;

import java.util.List;

import br.com.pathfinder.api.dto.UsuarioDTO;
import br.com.pathfinder.api.entity.Usuario;

public interface UsuarioService {
	UsuarioDTO save(UsuarioDTO usuario);
	UsuarioDTO update(UsuarioDTO usuario);
	void delete(Long id);
	UsuarioDTO findById(Long id);
	List<UsuarioDTO> findAll();
	
	UsuarioDTO Login(String login, String senha);
}
