package br.com.pathfinder.api.entity;
import java.util.List;

import com.google.common.collect.Lists;

public class Equipamento {
	public static final String TABLE = "PATHFINDER_EQUIPAMENTO";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";
	public static final String COL_CA = "CA";
	
	private Long id;
	private String nome;
	private Long ca;
	
	
	public Long getId() {							return id;					 }
	public void setId(Long id) {					this.id = id;				 }

	public String getNome() {						return nome;				 }
	public void setNome(String nome) {				this.nome = nome;			 }

	public Long getCa() {					return ca;			}
	public void setCa(Long ca) {		this.ca = ca;	}

	
	public Equipamento( Long id,String nome, Long ca){
		this.id				 = id;
		this.nome			 = nome;
		this.ca			 = ca;
	}
	
	
	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID, COL_NOME, COL_CA);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_NOME, COL_CA };
	}
}
