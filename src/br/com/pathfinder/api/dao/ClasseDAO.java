package br.com.pathfinder.api.dao;
import java.util.List;
import br.com.pathfinder.api.entity.Classe;

public interface ClasseDAO {
	Long save(Classe classe);
	void update(Classe classe);
	void delete(Long id);
	Classe findById(Long id);
	List<Classe> findAll();
}
