package br.com.pathfinder.api.dao;
import java.util.List;

import br.com.pathfinder.api.entity.Ataque;

public interface AtaqueDAO {
	Long save(Ataque ataque);
	void update(Ataque ataque);
	void delete(Ataque id);
	Ataque findById(Ataque id);
	List<Ataque> findAll();
}
