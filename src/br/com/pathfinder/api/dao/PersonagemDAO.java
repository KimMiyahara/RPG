package br.com.pathfinder.api.dao;
import java.util.List;


import br.com.pathfinder.api.entity.Personagem;
public interface PersonagemDAO {
	Long save(Personagem personagem);
	void update(Personagem personagem);
	void delete(Long id);
	Personagem findById(Long id);
	List<Personagem> findByUsuario(Long id);
	List<Personagem> findByMesa(Long id);
	List<Personagem> findPersonagens(Long id);
	List<Personagem> findAll();

	
}
