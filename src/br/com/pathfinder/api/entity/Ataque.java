package br.com.pathfinder.api.entity;

public class Ataque {
	public static final String TABLE = "PATHFINDER_ATAQUE";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";
	public static final String COL_TIPO = "TIPO";
	public static final String COL_DISTANCIA = "DISTANCIA";
	public static final String COL_DANO_BASE = "DANO_BASE";
	public static final String COL_DANO_ADICIONAL = "DANO_ADICIONAL";
	public static final String COL_ACERTO = "ACERTO";
	public static final String COL_CRITICO = "CRITICO";
	

	private Long id;
	private String nome;
	private String tipo;
	private Long distancia;
	private Long dano_base;
	private Long dano_adicional;
	private Long acerto;
	private String critico;
	
	
	public Long getId() {							return id;					}
	public void setId(Long id) {					this.id = id;				}

	public String getNome() {						return nome;				}
	public void setNome(String nome) {				this.nome = nome;			}

	public String getTipo() {						return tipo;				}
	public void setTipo(String tipo) {				this.tipo = tipo;			}

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


	
	public Ataque( Long id,String nome, String tipo, Long distancia, Long dano_base, Long dano_adicional, Long acerto, String critico){
		this.id				 = id;
		this.nome			 = nome;
		this.tipo			 = tipo;
		this.distancia		 = distancia;
		this.dano_base		 = dano_base;
		this.dano_adicional	 = dano_adicional;
		this.acerto	 		 = acerto;
		this.critico		 = critico;
	}
}
