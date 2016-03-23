package br.com.pathfinder.api.dao;
import java.util.List;

import br.com.pathfinder.api.entity.Arma;

public interface ArmaDAO {
	Long save(Arma Arma);
	void update(Arma Arma);
	void delete(Long id);
	Arma findById(Long id);
	List<Arma> findAll();
}
