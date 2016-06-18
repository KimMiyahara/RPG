package br.com.pathfinder.api.dto;


import java.util.List;
import java.util.Set;

import br.com.pathfinder.api.entity.Mesa;
import br.com.pathfinder.api.entity.Personagem;
import br.com.pathfinder.api.entity.Usuario;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;


public class UsuarioDTO {
	private Long id;
	private String nome;
	private String login;
	private String senha;
	
	List <MesaDTO> mesas =Lists.newArrayList() ;
	List <PersonagemDTO> personagens = Lists.newArrayList();
	
	
	
	public Long getId() {				return id;		}
	public void setId(Long id) {		this.id = id;		}
	
	public String getNome() {				return nome;	}
	public void setNome(String nome) {		this.nome = nome;	}
	
	public String getLogin() {				return login;		}
	public void setLogin(String login) {	this.login = login;	}
	
	public String getSenha() {				return senha;		}
	public void setSenha(String senha) {	this.senha = senha;	}
	
	public void  setMesas(List<MesaDTO> mes){		this.mesas = mes;	}
	public List<MesaDTO> getMesas() {				return mesas;		}
	
	
	public void setPersonagens(List<PersonagemDTO> per){ this.personagens=per;}
	public List<PersonagemDTO> getPersonagem(){return this.personagens;}
	
	public	UsuarioDTO Login(String login, String senha){
		if (this.login.equals(login) & this.senha.equals(senha)){
			return this;
		}return null;
	}
	UsuarioDTO(Long id, String nome,String login, String senha, List <PersonagemDTO> personagens,List <MesaDTO> mesas){
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;	
		this.mesas = mesas;
	}
	
	public UsuarioDTO() {}
	public String toString() {
		return id +" ,"+ nome+" ,"+login+" ,"+ senha +"\nPersonagens:"+personagens+"\nMesas:"+mesas +"\n";
	}
}
