package br.com.pathfinder.api.entity;
import java.util.List;

import com.google.common.collect.Lists;

public class Mesa {
	public static final String TABLE = "PATHFINDER_MESA";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";
	public static final String COL_MESTRE = "MESTRE";
	
	private Long id;
	private String nome;
	private Long mestre;
	
	
	public Long getId() {							return id;					}
	public void setId(Long id) {					this.id = id;				}

	public String getNome() {						return nome;				}
	public void setNome(String nome) {				this.nome = nome;			}

	public Long getMestre() {							return mestre;				}
	public void setMestre(Long mestre) {				this.mestre = mestre;	}

	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID, COL_NOME, COL_MESTRE);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_NOME, COL_MESTRE};
	}
}
