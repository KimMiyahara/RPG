package br.com.pathfinder.core.service;

import java.util.List;

import br.com.pathfinder.api.dao.ClasseDAO;
import br.com.pathfinder.api.dao.MesaDAO;
import br.com.pathfinder.api.dao.PersonagemDAO;
import br.com.pathfinder.api.dao.UsuarioDAO;
import br.com.pathfinder.api.dto.PersonagemDTO;
import br.com.pathfinder.api.entity.Personagem;
import br.com.pathfinder.api.service.PersonagemService;
import br.com.pathfinder.core.dto.ConversorClasse;
import br.com.pathfinder.core.dto.ConversorMesa;
import br.com.pathfinder.core.dto.ConversorPersonagem;
import br.com.pathfinder.core.dto.ConversorUsuario;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class PersonagemServiceImpl implements PersonagemService{
	private PersonagemDAO perdao;
	
	private ConversorPersonagem percon;
	
	public PersonagemServiceImpl() {
		
		this.perdao = ImplFinder.getImpl(PersonagemDAO.class);
		
		this.percon = ImplFinder.getFinalImpl(ConversorPersonagem.class);
	}
	@Override
	public PersonagemDTO save(PersonagemDTO personagemDTO) {
		Personagem persona = this.percon.toEntity(personagemDTO);
		if(personagemDTO.getId()!=null){
			this.perdao.update(persona);
		}else{
			Long id = this.perdao.save(persona);
			personagemDTO.setId(id);
		}
		
		
		return personagemDTO;
	}

	@Override
	public void update(PersonagemDTO personagemDTO) {
		Personagem persona = this.percon.toEntity(personagemDTO);
		this.perdao.update(persona);
		
	}

	@Override
	public void delete(Long personagemID) {
		this.perdao.delete(personagemID);
	}

	@Override
	public List<PersonagemDTO> findALL() {
		// TODO Auto-generated method stub
		List<Personagem> lst = this.perdao.findAll();
		return this.percon.toDTO(lst);
	}

	@Override
	public PersonagemDTO searchID(Long personagemID) {
		Personagem persona = this.perdao.findById(personagemID);
		//PersonagemDTO dt =	this.percon.toDTO(persona);	
		
		if (persona != null){		return	this.percon.toDTO(persona);		}
		return null;
	}
	@Override
	public List<PersonagemDTO> findUsuario(Long Id) {
		List<Personagem> lst = this.perdao.findByUsuario(Id);
		return this.percon.toDTO(lst);
	}
	@Override
	public List<PersonagemDTO> findMesa(Long Id) {
		List<Personagem> lst = this.perdao.findByMesa(Id);
		return this.percon.toDTO(lst);
	}
	
	
}
