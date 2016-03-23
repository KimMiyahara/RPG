package br.com.pathfinder.api.dao;
import java.util.List;

import br.com.pathfinder.api.entity.Personagem;

public interface PersonagemDAO {
	Long save(Personagem Personagem);
	void update(Personagem Personagem);
	void delete(Long id);
	Personagem findById(Long id);
	List<Personagem> findAll();
}
