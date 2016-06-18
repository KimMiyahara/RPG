package br.com.pathfinder.core.dto;

import java.util.List;

import com.google.common.collect.Lists;


import br.com.pathfinder.api.dto.MesaDTO;
import br.com.pathfinder.api.entity.Mesa;
import br.com.spektro.minispring.dto.DTOConverter;

public class ConversorMesa implements DTOConverter<Mesa, MesaDTO>{

	@Override
	public MesaDTO toDTO(Mesa mes) {
		MesaDTO dto = new MesaDTO();
		dto.setId(mes.getId());
		dto.setNome(mes.getNome());
		dto.setMestre(mes.getMestre());
		return dto;
	}

	@Override
	public List<MesaDTO> toDTO(List<Mesa> lst) {
		List<MesaDTO> dto =  Lists.newArrayList();
		for( Mesa i: lst ){
			dto.add(toDTO(i));
		}
		return dto;
	}

	@Override
	public Mesa toEntity(MesaDTO dto) {
		Mesa mes = new Mesa();
		mes.setId(dto.getId());
		mes.setNome(dto.getNome());
		mes.setMestre(dto.getMestre());
		return mes;
	}

	@Override
	public List<Mesa> toEntity(List<MesaDTO> dto) {
		List<Mesa> lst =  Lists.newArrayList();
		for( MesaDTO i: dto ){
			lst.add(toEntity(i));
		}
		return lst;
	}

}
