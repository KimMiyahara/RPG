package br.com.pathfinder.api.dao;
import java.util.List;


import br.com.pathfinder.api.entity.Mesa;

public interface MesaDAO {
	Long save(Mesa mesa);
	void update(Mesa mesa);
	void delete(Long id);
	Mesa findById(Long id);
	List<Mesa> findByMestre(Long id);
	List<Mesa> findAll();
}
