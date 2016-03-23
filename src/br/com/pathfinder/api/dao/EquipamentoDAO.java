package br.com.pathfinder.api.dao;
import java.util.List;

import br.com.pathfinder.api.entity.Equipamento;

public interface EquipamentoDAO {
	Long save(Equipamento Equipamento);
	void update(Equipamento Equipamento);
	void delete(Long id);
	Equipamento findById(Long id);
	List<Equipamento> findAll();
}


