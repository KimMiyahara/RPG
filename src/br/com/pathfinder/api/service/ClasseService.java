package br.com.pathfinder.api.service;

import java.util.List;

import br.com.pathfinder.api.dto.ClasseDTO;
import br.com.pathfinder.api.entity.Classe;

public interface ClasseService {
	Long save(ClasseDTO classe);
	void update(ClasseDTO classe);
	void delete(Long id);
	ClasseDTO findById(Long id);
	List<ClasseDTO> findAll();
}
