/**
 * 
 */
package br.com.pathfinder.core.service;

import java.util.List;

import br.com.pathfinder.api.dao.ClasseDAO;
import br.com.pathfinder.api.dto.ClasseDTO;
import br.com.pathfinder.api.entity.Classe;
import br.com.pathfinder.api.service.ClasseService;
import br.com.pathfinder.core.dto.ConversorClasse;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

/**
 * @author usuario
 *
 */
public class ClasseServiceImpl implements ClasseService{
	private ClasseDAO cladao;
	private ConversorClasse clacon;
	
	public ClasseServiceImpl() {
		this.cladao = ImplFinder.getImpl(ClasseDAO.class);
		this.clacon = ImplFinder.getFinalImpl(ConversorClasse.class);
		
	}
	
	@Override
	public Long save(ClasseDTO classeDTO) {
		Classe classe = this.clacon.toEntity(classeDTO);
		if (classeDTO.getId()!=null){
			this.cladao.update(classe);
		}else{
			Long id = this.cladao.save(classe);
			classeDTO.setId(id);
		}
		
		return classeDTO.getId();
	}

	@Override
	public void update(ClasseDTO classeDTO) {
		Classe classe = this.clacon.toEntity(classeDTO);
		this.cladao.update(classe);
	}

	@Override
	public void delete(Long id) {
		this.cladao.delete(id);		
	}

	@Override
	public ClasseDTO findById(Long id) {
		Classe classe = this.cladao.findById(id);
		if (classe !=null){ return this.clacon.toDTO(classe);}
		return null;
	}

	@Override
	public List<ClasseDTO> findAll() {
		List<Classe> classe = this.cladao.findAll();
		return this.clacon.toDTO(classe);
	}

}
