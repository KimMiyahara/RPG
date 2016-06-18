package br.com.pathfinder.api.dto;

public class ClasseDTO {
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
	

	
	public String toString() {
		return id +" "+ nome + " dv:" + dado_vida + " bba:"+bba+"  f:"+ fort+" r:"+ refl+" v:"+ vont;
	}
}
