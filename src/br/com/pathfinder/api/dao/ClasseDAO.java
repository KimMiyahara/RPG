package br.com.pathfinder.api.dao;
import java.util.List;

import br.com.pathfinder.api.entity.Classe;

public interface ClasseDAO {
	Long save(Classe Classe);
	void update(Classe Classe);
	void delete(Long id);
	Classe findById(Long id);
	List<Classe> findAll();
}
