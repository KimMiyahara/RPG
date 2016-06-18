package br.com.pathfinder.core.dto;



import java.util.List;

import br.com.spektro.minispring.dto.DTOConverter;
import br.com.pathfinder.api.entity.Classe;
import br.com.pathfinder.api.dto.ClasseDTO;
import com.google.common.collect.Lists;
public class ConversorClasse implements DTOConverter<Classe, ClasseDTO>{
	@Override
	public ClasseDTO toDTO(Classe cla) {
		ClasseDTO dto = new ClasseDTO();
		dto.setId(cla.getId());
		dto.setNome(cla.getNome());
		dto.setBba(cla.getBba());
		dto.setFort(cla.getFort());
		dto.setRefl(cla.getRefl());
		dto.setVont(cla.getVont());
		dto.setDado_vida(cla.getDado_vida());
		return dto;
	}

	@Override
	public Classe toEntity(ClasseDTO dto) {
		Classe cla = new Classe();
		cla.setId(dto.getId());
		cla.setNome(dto.getNome());
		cla.setBba(dto.getBba());
		cla.setFort(dto.getFort());
		cla.setRefl(dto.getRefl());
		cla.setVont(dto.getVont());
		cla.setDado_vida(dto.getDado_vida());
		return cla;
	}

	@Override
	public List<ClasseDTO> toDTO(List<Classe> lst) {
		List<ClasseDTO> dto =  Lists.newArrayList();
		for( Classe i: lst ){
			dto.add(toDTO(i));
		}
		return dto;
	}

	@Override
	public List<Classe> toEntity(List<ClasseDTO> lst) {
		List<Classe> normal =  Lists.newArrayList();
		for( ClasseDTO i: lst ){
			normal.add(toEntity(i));
		}
		return normal;
	}
	
	
}
