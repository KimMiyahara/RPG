package br.com.pathfinder.web.action;

import br.com.pathfinder.api.dto.ClasseDTO;
import br.com.pathfinder.api.service.ClasseService;
import br.com.pathfinder.web.context.ContextoClasse;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ClasseAction  extends PathfinderAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 775883766689551825L;

	private static String FOI = "carai";
	
	private ContextoClasse contexto = new ContextoClasse();
	private ClasseService service;
	
	public ClasseAction() {
		this.service = ImplFinder.getImpl(ClasseService.class);
	}
	public String todas(){
		this.contexto.setClasses(this.service.findAll());
		return FOI;
	}
	public String salvar(){
		if (this.contexto.getClasse().getId()!= null){
			this.service.update(this.contexto.getClasse());
		}else{
			this.service.save(this.contexto.getClasse());
		}
		return this.todas();
	}
	public String editar(){
		ClasseDTO classe = 	this.service.findById(this.contexto.getClasse().getId());
		this.contexto.setClasse(classe);
		return this.todas();
	}
	public String deletar(){
		this.service.delete(this.contexto.getClasse().getId());
		return this.todas();
	}
	
	public ContextoClasse getContexto(){				return this.contexto;		}
	public void setContexto(ContextoClasse contexto){	this.contexto = contexto;	}
}
