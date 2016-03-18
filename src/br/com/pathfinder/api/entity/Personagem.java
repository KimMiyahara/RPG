package br.com.pathfinder.api.entity;

public class Personagem {
	public static final String TABLE = "PATHFINDER_PERSONAGEM";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";
	public static final String COL_USUARIO = "USUARIO";
	public static final String COL_CLASSE = "CLASSE";
	public static final String COL_LVL = "LVL";
	public static final String COL_FORC = "FORC";
	public static final String COL_DEST = "DEST";
	public static final String COL_CONS = "CONS";
	public static final String COL_INTE = "INTE";
	public static final String COL_SABE = "SABE";
	public static final String COL_CARI = "CARI";

	
	
	private Long id;
	private String nome;
	private Long usuario;
	private String classe;
	private Long lvl;
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
	public String getClasse() {					return classe;			}
	public void setClasse(String classe) {		this.classe = classe;	}
	
//lvl
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
	
	
}
