package br.com.pathfinder.web.action;

import br.com.pathfinder.api.dto.MesaDTO;
import br.com.pathfinder.api.service.MesaService;
import br.com.pathfinder.web.context.ContextoMesa;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class MesaAction extends PathfinderAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7381718340994853574L;

	private static String FOI = "carai";

	private ContextoMesa contexto = new ContextoMesa();
	private MesaService service;
	
	public MesaAction(){
		this.service = ImplFinder.getImpl(MesaService.class);
	}
	
	public String todas(){
		this.contexto.setMesas(this.service.findAll());
		return FOI;
	}
	public String salvar(){
		if (this.contexto.getMesa().getId()!= null){
			this.service.update(this.contexto.getMesa());
		}else{
			this.service.save(this.contexto.getMesa());
		}
		return this.todas();
	}
	
	public String editar(){
		MesaDTO mesa = this.service.findById(this.contexto.getMesa().getId());
		this.contexto.setMesa(mesa);
		return this.todas();
	}
	public String deletar(){
		this.service.delete(this.contexto.getMesa().getId());
		return this.todas();
	}
	public ContextoMesa getContexto(){	return this.contexto;	}
	public void setContexto(ContextoMesa contexto){ this.contexto=contexto;}
	
}
