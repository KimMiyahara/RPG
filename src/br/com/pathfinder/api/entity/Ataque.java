package br.com.pathfinder.api.entity;

import java.util.List;

import com.google.common.collect.Lists;

public class Ataque {
	public static final String TABLE = "PATHFINDER_ATAQUE";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";
	public static final String COL_PERSONAGEM = "PERSONAGEM";
	public static final String COL_DISTANCIA = "DISTANCIA";
	public static final String COL_DANO_BASE = "DANO_BASE";
	public static final String COL_DANO_ADICIONAL = "DANO_ADICIONAL";
	public static final String COL_ACERTO = "ACERTO";
	public static final String COL_CRITICO = "CRITICO";
	

	private Long id;
	private String nome;
	private Long arma_id;
	private Long personagem;
	private Long distancia;
	private Long dano_base;
	private Long dano_adicional;
	private Long acerto;
	private String critico;
	
	
	public Long getId() {							return id;					 }
	public void setId(Long id) {					this.id = id;				 }

	public Long getArmaId() {								return arma_id;					 }
	public void setArmaId(Long arma_id) {					this.arma_id = arma_id;				 }
	
	public String getNome() {						return nome;				 }
	public void setNome(String nome) {				this.nome = nome;			 }

	public Long getPersonagem() {					return personagem;			 }
	public void setPersonagem(Long personagem) {	this.personagem = personagem;}

	public Long getDistancia() {					return distancia;			}
	public void setDistancia(Long distancia) {		this.distancia = distancia;	}

	public Long getDano_base() {					return dano_base;			}
	public void setDano_base(Long dano_base) {		this.dano_base = dano_base;	}


	public Long getDano_adicional() {						return dano_adicional;					}
	public void setDano_adicional(Long dano_adicional) {	this.dano_adicional = dano_adicional;	}


	public Long getAcerto() {					return acerto;			}
	public void setAcerto(Long acerto) {		this.acerto = acerto;	}

	public String getCritico() {				return critico;			}
	public void setCritico(String critico) {	this.critico = critico;	}

	public Ataque(){}
	
	public Ataque( Long id,String nome, Long personagem, Long distancia, Long dano_base, Long dano_adicional, Long acerto, String critico){
		this.id				 = id;
		this.nome			 = nome;
		this.personagem		 = personagem;
		this.distancia		 = distancia;
		this.dano_base		 = dano_base;
		this.dano_adicional	 = dano_adicional;
		this.acerto	 		 = acerto;
		this.critico		 = critico;
	}
	
	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID, COL_NOME,COL_PERSONAGEM, COL_DISTANCIA, COL_DANO_BASE,COL_DANO_ADICIONAL, COL_ACERTO, COL_CRITICO);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_NOME, COL_PERSONAGEM, COL_DISTANCIA, COL_DANO_BASE,COL_DANO_ADICIONAL, COL_ACERTO, COL_CRITICO };
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+" ,"+ nome+" ,"+ personagem+" ,"+distancia+" ,"+dano_base+" ,"+dano_adicional+" ,"+acerto+" ,"+critico;
	}
}
