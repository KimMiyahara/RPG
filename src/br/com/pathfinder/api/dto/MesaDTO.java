package br.com.pathfinder.api.dto;

import java.util.List;

import com.google.common.collect.Lists;

public class MesaDTO {
	private Long id;
	private String nome;
	private Long mestre;
	
	private List<PersonagemDTO> personas = Lists.newArrayList();
	
	public MesaDTO (){}
		
	public MesaDTO ( Long id, String nome, Long mestre){
		this.id 	= id;
		this.nome 	= nome;
		this.mestre = mestre;
	}
	
	public Long getId() {							return id;					}
	public void setId(Long id) {					this.id = id;				}

	public String getNome() {						return nome;				}
	public void setNome(String nome) {				this.nome = nome;			}

	public Long getMestre() {							return mestre;			}
	public void setMestre(Long mestre) {				this.mestre = mestre;	}
	
	public void setPersonas(List<PersonagemDTO> personas) {		this.personas = personas;	}
	public  List<PersonagemDTO> getPersonas() {					return personas;			}
	
	@Override
	public String toString() {
		return id+" ,"+nome+" ,"+ mestre+"\n "+personas;
	}
}
