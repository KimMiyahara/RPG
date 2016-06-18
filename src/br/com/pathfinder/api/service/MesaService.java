package br.com.pathfinder.api.service;

import java.util.List;

import br.com.pathfinder.api.dto.MesaDTO;
import br.com.pathfinder.api.entity.Mesa;

public interface MesaService {
	Long save(MesaDTO mesa);
	void update(MesaDTO mesa);
	void delete(Long id);
	MesaDTO findById(Long id);
	List<MesaDTO> findByMestre(Long id);
	List<MesaDTO> findAll();
}
