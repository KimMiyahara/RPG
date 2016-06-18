package br.com.pathfinder.api.dto;

import br.com.pathfinder.api.entity.Classe;
import br.com.pathfinder.api.entity.Mesa;
import br.com.pathfinder.api.entity.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public class PersonagemDTO {
	private Long id;
	private String nome;
	private Usuario usuario;
	private Classe classe;
	private Long lvl=1L;
	private Mesa mesa;
//atributos
	private Long forc=0L;
	private Long dest=0L;
	private Long cons=0L;
	private Long inte=0L;
	private Long sabe=0L;
	private Long cari=0L;
	
	private Long mfor=0L;
	private Long mdes=0L;
	private Long mcon=0L;
	private Long mint=0L;
	private Long msab=0L;
	private Long mcar=0L;
//resistencias
	private Long fort=0L;
	private Long refl=0L;
	private Long vont=0L;
//bases
	private Long hp=0L;
	private Long hp_atual=0L;
	private Long ca=0L;
	private Long bba=0L;
	
//construtor
	public PersonagemDTO(){}
	
	public PersonagemDTO(Long id, String nome, Usuario usuario, Classe classe, Long lvl, Long forc, Long dest, Long cons, Long inte, Long sabe, Long cari, Mesa mesa){
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
		
		setAtrib();
	}
	
	public void setAtrib(){
		setMFor(forc);
		setMDes(dest);
		setMCon(cons);
		setMInt(inte);
		setMSab(sabe);
		setMCar(cari);
		Calculate();
	}
//id	
	public Long getId() {						return id;				}
	public void setId(Long id) {				this.id = id;			}
	
//nome	
	public String getNome() {					return nome;			}
	public void setNome(String nome) {			this.nome = nome;		}
//usuario
	public Usuario getUsuario() {				return usuario;			}
	public void setUsuario(Usuario usuario) {			this.usuario = usuario;		}
	
//classe	
	public Classe getClasse() {					return classe;			}
	public void setClasse(Classe classe) {		
		this.classe = classe;	
		Calculate();
	}
	
//lvl
	public Mesa getMesa() {						return mesa;				}
	public void setMesa(Mesa mesa) {			this.mesa = mesa;			}
//
	public Long getLvl() {						return lvl;				}
	public void setLvl(Long lvl) {				
		this.lvl = lvl;	
		Calculate();
	}
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
	
	
	public Long getMfor() {				return mfor;		}
	public void setMFor(Long forc) {	this.mfor = (this.forc-10)/2;	}
	//des
	public Long getMDes() {				return mdes;		}
	public void setMDes(Long dest) {	this.mdes = (this.dest-10)/2;	}
	//con
	public Long getMCon() {				return mcon;		}
	public void setMCon(Long cons) {	this.mcon = (this.cons-10)/2;	}
	//int
	public Long getMInt() {				return mint;		}
	public void setMInt(Long inte) {	this.mint = (this.inte-10)/2;	}
	//sab
	public Long getMSab() {				return msab;		}
	public void setMSab(Long sabe) {	this.msab = (this.sabe-10)/2;	}
	//car
	public Long getMCar() {				return mcar;		}
	public void setMCar(Long cari) {	this.mcar = (this.cari-10)/2;	}
	
	
//Resistencias
	public void setFort(Long fort){		this.fort=fort;				}
	public Long getFort() {				return fort;		}
	public Long getRefl() {				return refl;		}
	public Long getVont() {				return vont;		}

	
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
//calculo
	public void Calculate(){
		this.bba = this.classe.getBba()*this.lvl/4;
		
		this.fort=Resistence(this.classe.getFort())+this.mcon;
		this.refl=Resistence(this.classe.getRefl())+this.mdes;
		this.vont=Resistence(this.classe.getVont())+this.msab;
		this.hp = this.getClasse().getDado_vida()*this.getLvl();
		this.hp_atual=hp;
		//System.out.println("calculate "+ this.getNome()+"  "+hp);
//hp
/*		this.hp=0L;
		this.hp=this.classe.getDado_vida()+this.mcon;
		Random dice = new Random();
		
		List<Long> dices = Lists.newArrayList();
			
		for (int i=1;i<this.getLvl();i++){
			 int o =dice.nextInt(
					Integer.valueOf(this.classe.getDado_vida().intValue())
							)+1+Integer.valueOf(this.mcon.intValue());
			 if(o>=1){ 
				 dices.add((long)o);
				 this.hp=this.hp+(long)o;
			 }else{
				 dices.add((long)1);
				 this.hp++;
			 }
		}
*/
		/*for(Long d: dices){	System.out.print("+"+d);		}
		 		System.out.print("="+hp);
		 */
		
		
	}
//lvlup
	public void Levelup(){
		this.lvl= this.lvl+1;
	}
//calcular resistencia	
	public Long Resistence(Long res){
		if(res==1L)  return this.lvl/3;
		return this.lvl/2+2;
	}
	@Override
	public String toString() {
		return id+"|"+nome+"("+usuario+")cl:"+classe.getNome()+" "+lvl+"\nhp "+hp_atual+"/"+hp+"  ca "+ca + "\n fo"+forc+"|"+mfor+" de"+dest+"|"+mdes+" co"+cons+"|"+mcon+" in"+inte+"|"+mint+" sa"+sabe+"|"+msab+" ca"+cari+"|"+mcar+"\n fort "+fort+"  ref "+refl+"  von"+vont+"\n mesa:"+mesa.getId()+"bba:"+this.bba ;
	}
}
