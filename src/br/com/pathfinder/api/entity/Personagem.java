package br.com.pathfinder.api.entity;
import java.util.List;

import com.google.common.collect.Lists;

public class Personagem {
	public static final String TABLE = "PATHFINDER_PERSONAGEM";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";
	public static final String COL_USUARIO = "USUARIO";
	public static final String COL_CLASSE = "CLASSE";
	public static final String COL_LVL = "LVL";
	public static final String COL_MESA = "MESA";
	public static final String COL_FORC = "FORC";
	public static final String COL_DEST = "DEST";
	public static final String COL_CONS = "CONS";
	public static final String COL_INTE = "INTE";
	public static final String COL_SABE = "SABE";
	public static final String COL_CARI = "CARI";
	public static final String COL_FORT = "FORT";
	public static final String COL_REFL = "REFL";
	public static final String COL_VONT = "VONT";
	public static final String COL_HP = "HP";
	public static final String COL_CA = "CA";
	public static final String COL_BBA = "BBA";
	
	
	private Long id;
	private String nome;
	private Long usuario;
	private Classe classe;
	private Long lvl;
	private Long mesa;
//atributos
	private Long forc;
	private Long dest;
	private Long cons;
	private Long inte;
	private Long sabe;
	private Long cari;
//resistencias
	private Long fort;
	private Long refl;
	private Long vont;
//bases
	private Long hp;
	private Long ca;
	private Long bba;
	
//id	
	public Long getId() {						return id;				}
	public void setId(Long id) {				this.id = id;			}
	
//nome	
	public String getNome() {					return nome;			}
	public void setNome(String nome) {			this.nome = nome;		}
//usuario
	public Long getUsuario() {				return usuario;			}
	public void setUsuario(Long usuario) {			this.usuario = usuario;		}
	
//classe	
	public Classe getClasse() {					return classe;			}
	public void setClasse(Classe classe) {		this.classe = classe;	}
	
//lvl
	public Long getMesa() {						return mesa;				}
	public void setMesa(Long mesa) {			this.mesa = mesa;			}
//
	public Long getLvl() {						return lvl;				}
	public void setLvl(Long lvl) {				this.lvl = lvl;			}
//Atributos
	//for	
	public Long getForc() {				return forc;		}
	public void setForc(Long forc) {	this.forc = forc;	}
	//des
	public Long getDest() {				return dest;		}
	public void setDest(Long dest) {	this.dest = dest;	}
	//con
	public Long getCons() {				return cons;		}
	public void setCons(Long cons) {	this.cons = cons;	}
	//int
	public Long getInte() {				return inte;		}
	public void setInte(Long inte) {	this.inte = inte;	}
	//sab
	public Long getSabe() {				return sabe;		}
	public void setSabe(Long sabe) {	this.sabe = sabe;	}
	//car
	public Long getCari() {				return cari;		}
	public void setCari(Long cari) {	this.cari = cari;	}
	
//Resistencias
	public Long getFort() {				return fort;		}
	public void setFort(Long fort) {	this.fort = fort;	}
	public Long getRefl() {				return refl;		}
	public void setRefl(Long refl) {	this.refl = refl;	}
	public Long getVont() {				return vont;		}
	public void setVont(Long vont) {	this.vont = vont;	}
	
//Bases	
	//hp
	public Long getHP() {				return hp;	}
	public void setHP(Long hp) {		this.hp = hp;	}
	//ca
	public Long getCa() {				return ca;	}
	public void setCa(Long ca) {		this.ca = ca;	}
	//bba
	public Long getBba() {				return bba;	}
	public void setBBA(Long bba) {		this.bba = bba;	}

	public Personagem(){}
	
	public Personagem(Long id, String nome, Long usuario, Classe classe, Long lvl, Long forc, Long dest, Long cons, Long inte, Long sabe, Long cari, Long mesa){
		this.id	 		= id;
		this.nome		= nome;
		this.usuario	= usuario;
		this.classe		= classe;
		this.lvl 		= lvl;
		this.forc			= forc;
		this.dest			= dest;
		this.cons			= cons;
		this.inte			= inte;
		this.sabe			= sabe;
		this.cari			= cari;
		this.mesa			= mesa;	
	}
	
	
	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID , COL_NOME, COL_USUARIO, COL_CLASSE, COL_LVL,COL_MESA, COL_FORC, COL_DEST, COL_CONS, COL_INTE, COL_SABE, COL_CARI); 
	}
	public static String[] getColunasArray() {
		return new String[] {COL_ID , COL_NOME, COL_USUARIO, COL_CLASSE, COL_LVL,COL_MESA, COL_FORC, COL_DEST, COL_CONS, COL_INTE, COL_SABE, COL_CARI};
	}
}
