package br.com.pathfinder.api.entity;

import java.util.List;

import com.google.common.collect.Lists;

public class Classe {
	public static final String TABLE = "PATHFINDER_CLASSE";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";
	public static final String COL_BBA = "BBA";
	public static final String COL_FORT = "FORT";
	public static final String COL_REFL = "REFL";
	public static final String COL_VONT = "VONT";	
	public static final String COL_DADO_VIDA = "DADO_VIDA";
	
	private Long id;
	private String nome;
	private Long bba;
	private Long fort;
	private Long refl;
	private Long vont;
	private Long dado_vida;

	public Long getId() {						return id;					}
	public void setId(Long id) {				this.id = id;				}

	public String getNome() {					return nome;				}
	public void setNome(String nome) {			this.nome = nome;			}

	public Long getBba() {						return bba;					}	
	public void setBba(Long bba) {				this.bba = bba;				}

	public Long getFort() {						return fort;				}
	public void setFort(Long fort) {			this.fort = fort;			}

	public Long getRefl() {						return refl;				}
	public void setRefl(Long refl) {			this.refl = refl;			}

	public Long getVont() {						return vont;				}
	public void setVont(Long vont) {			this.vont = vont;			}

	public Long getDado_vida() {				return dado_vida;			}
	public void setDado_vida(Long dado_vida) {	this.dado_vida = dado_vida;	}
	
	public Classe(){}
	
	public Classe(Long id, String nome, Long bba, Long fort, Long refl, Long vont, Long dado_vida){
		this.id			=	id;
		this.nome		=	nome;
		this.bba		=	bba;
		this.fort		=	fort;
		this.refl		=	refl;
		this.vont		=	vont;
		this.dado_vida	=	dado_vida;
	}
	
	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID, COL_NOME, COL_BBA,COL_FORT,COL_REFL,COL_VONT, COL_DADO_VIDA);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_NOME, COL_BBA,COL_FORT,COL_REFL,COL_VONT, COL_DADO_VIDA};
	}
	
	@Override
	public String toString() {
		return id +" "+ nome + " dv:" + dado_vida + " bba:"+bba+"  f:"+ fort+" r:"+ refl+" v:"+ vont;
	}
}
