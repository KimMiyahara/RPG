package br.com.pathfinder.web.action;

import br.com.pathfinder.api.dto.PersonagemDTO;
import br.com.pathfinder.api.service.PersonagemService;
import br.com.pathfinder.web.context.ContextoPersonagem;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class PersonagemAction {

	private static String FOI = "carai";

	private ContextoPersonagem contexto = new ContextoPersonagem();
	private PersonagemService service;
	
	public PersonagemAction() {
		this.service = ImplFinder.getImpl(PersonagemService.class);
	}
	
	public String todas(){
		this.contexto.setPersonagens(this.service.findALL());
		return FOI;
	}
	
	
	public String salvart(){
		if(this.contexto.getPersonagem().getId()!=null){
			this.service.update(this.contexto.getPersonagem());
		}else{
			this.service.save(this.contexto.getPersonagem());
		}
		return this.todas();
	}
	
	public String editar(){
		PersonagemDTO personagem = this.service.searchID(this.contexto.getPersonagem().getId());
		this.contexto.setPersonagem(personagem);
		return this.todas();
	}
	
	public String deletar(){
		this.service.delete(this.contexto.getPersonagem().getId());
		return this.todas();
	}
	
	public ContextoPersonagem getContexto() {				return contexto;	}
	public void setContexto(ContextoPersonagem contexto) {	this.contexto = contexto;	}
	
	
}
