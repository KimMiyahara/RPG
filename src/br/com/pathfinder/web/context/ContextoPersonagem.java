package br.com.pathfinder.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.pathfinder.api.dto.PersonagemDTO;

public class ContextoPersonagem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1696133972722003453L;
	
	private PersonagemDTO personagem;
	private List<PersonagemDTO> personagens;
	
	public PersonagemDTO getPersonagem() {			return personagem;	}
	public List<PersonagemDTO> getPersonagens() {	return personagens;	}
	
	public void setPersonagem(PersonagemDTO personagem) {			this.personagem = personagem;	}
	public void setPersonagens(List<PersonagemDTO> personagens) {	this.personagens = personagens;	}

}
