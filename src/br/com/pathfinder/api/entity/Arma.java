package br.com.pathfinder.api.entity;


import java.util.List;

import com.google.common.collect.Lists;

public class Arma {
	public static final String TABLE = "PATHFINDER_ARMA";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";
	public static final String COL_DISTANCIA = "DISTANCIA";
	public static final String COL_DANO = "DANO";
	public static final String COL_CRITICO = "CRITICO";
	

	private Long id;
	private String nome;
	private Long distancia;
	private Long dano;
	private String critico;
	
	
	public Long getId() {							return id;					 }
	public void setId(Long id) {					this.id = id;				 }

	public String getNome() {						return nome;				 }
	public void setNome(String nome) {				this.nome = nome;			 }

	public Long getDistancia() {					return distancia;			}
	public void setDistancia(Long distancia) {		this.distancia = distancia;	}

	public Long getDano() {					return dano;			}
	public void setDano(Long dano) {		this.dano = dano;	}

	public String getCritico() {				return critico;			}
	public void setCritico(String critico) {	this.critico = critico;	}


	
	public Arma( Long id,String nome, Long personagem, Long distancia, Long dano, String critico){
		this.id				 = id;
		this.nome			 = nome;
		this.distancia		 = distancia;
		this.dano			 = dano;
		this.critico		 = critico;
	}
	
	
	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID, COL_NOME, COL_DISTANCIA, COL_DANO, COL_CRITICO);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_NOME, COL_DISTANCIA, COL_DANO, COL_CRITICO };
	}
}
