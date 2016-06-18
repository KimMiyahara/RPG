package br.com.pathfinder.core.dto;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.pathfinder.api.dto.PersonagemDTO;

import br.com.pathfinder.api.entity.Personagem;

import br.com.spektro.minispring.dto.DTOConverter;

public class ConversorPersonagem implements DTOConverter<Personagem, PersonagemDTO>{

	@Override
	public PersonagemDTO toDTO(Personagem per) {
		PersonagemDTO dto = new PersonagemDTO();
		dto.setId(per.getId());
		dto.setNome(per.getNome());
		dto.setUsuario(per.getUsuario());
		dto.setClasse(per.getClasse());
		dto.setMesa(per.getMesa());
		dto.setLvl(per.getLvl());
		dto.setForc(per.getForc());
		dto.setDest(per.getDest());
		dto.setCons(per.getCons());
		dto.setInte(per.getInte());
		dto.setSabe(per.getSabe());
		dto.setCari(per.getCari());
		dto.setBBA(per.getBba());
		dto.setHP(per.getHP());
				
		dto.setAtrib();
		dto.getCa();
		
		return dto;
	}

	@Override
	public List<PersonagemDTO> toDTO(List<Personagem> pers) {
		List<PersonagemDTO> dto = Lists.newArrayList();
		for (Personagem i:pers){
			dto.add(toDTO(i));
		}
		return dto;
	}

	@Override
	public Personagem toEntity(PersonagemDTO dto) {
		Personagem per = new Personagem(	dto.getId(),dto.getNome(),dto.getUsuario(),
				dto.getClasse(),dto.getLvl(),
				dto.getForc(),dto.getDest(),dto.getCons(),dto.getInte(),dto.getSabe(),dto.getCari(),
				dto.getMesa());
		
		return per;
	}

	@Override
	public List<Personagem> toEntity(List<PersonagemDTO> dto) {
		List<Personagem> pers = Lists.newArrayList();
		for (PersonagemDTO i: dto){
			pers.add(toEntity(i));
		}
		return pers;
	}
	
	

}
