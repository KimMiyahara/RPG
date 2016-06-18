package br.com.pathfinder.api.dao;

import java.util.List;

import br.com.pathfinder.api.entity.Usuario;

public interface UsuarioDAO {
	Long save(Usuario usuario);
	void update(Usuario usuario);
	void delete(Long id);
	Usuario findById(Long id);
	List<Usuario> findAll();
	
	Usuario Login(String login, String senha);
	
}
