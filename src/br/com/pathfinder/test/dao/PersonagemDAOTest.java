package br.com.pathfinder.test.dao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import org.junit.Assert;

import br.com.pathfinder.api.dao.UsuarioDAO;
import br.com.pathfinder.api.dto.PersonagemDTO;
import br.com.pathfinder.api.entity.Usuario;
import br.com.pathfinder.core.dto.ConversorPersonagem;
import br.com.pathfinder.api.dao.ClasseDAO;
import br.com.pathfinder.api.dao.MesaDAO;
import br.com.pathfinder.api.entity.Classe;
import br.com.pathfinder.api.entity.Mesa;
import br.com.pathfinder.api.dao.PersonagemDAO;
import br.com.pathfinder.api.entity.Personagem;

import br.com.pathfinder.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class PersonagemDAOTest extends TestBase {
	private UsuarioDAO usr;
	private MesaDAO mes;
	private ClasseDAO cla;
	private PersonagemDAO dao;
		
	List<Usuario> usu_sal ;
	List<Mesa> mes_all ;
	List<Classe> cla_all ;
	
	@Before
	public void config() {
		this.usr = ImplFinder.getImpl(UsuarioDAO.class);
		this.mes = ImplFinder.getImpl(MesaDAO.class);
		this.cla = ImplFinder.getImpl(ClasseDAO.class);
		this.dao = ImplFinder.getImpl(PersonagemDAO.class);
		
		Usuario usu_salvar = new Usuario(null, "Kim", "Miyahara", "tenchu3");
		Usuario usu_salvar2 = new Usuario(null, "Kazuo", "Miyahara2", "senha");
		Usuario usu_salvar3 = new Usuario(null, "Miki", "Karen", "senha2");
		
		usr.save(usu_salvar);
		usr.save(usu_salvar2);
		usr.save(usu_salvar3);
		
		usu_sal= this.usr.findAll();		
		
		Mesa mes_salvar = new Mesa(null, "Mesa1", usu_sal.get(1).getId());
		Mesa mes_salvar2 = new Mesa(null, "Mesa2", usu_sal.get(0).getId());
		Mesa mes_salvar3 = new Mesa(null, "Mesa3", usu_sal.get(2).getId());
		
		
		mes.save(mes_salvar);
		mes.save(mes_salvar2);
		mes.save(mes_salvar3);
		
		mes_all= this.mes.findAll();
		
		Classe cla_salvar = new Classe(null, "Guerreiro",4L,2L,1L,1L,10L);

		Classe cla_salvar2 = new Classe(null, "Ladino",3L,1L,2L,1L,6L);
		Classe cla_salvar3 = new Classe(null, "Mago",2L,1L,1L,2L,4L);

		cla.save(cla_salvar);
		cla.save(cla_salvar2);
		cla.save(cla_salvar3);
		
	
		
		cla_all= this.cla.findAll();
	}
	

	@Test
	public void testSave() {

		Personagem persona = new Personagem(null, "Darius",
				usu_sal.get(1), cla_all.get(1), 5L, 12L, 14L, 12L, 22L, 14L, 12L, mes_all.get(1));
			
			Long id=  this.dao.save(persona);
		Personagem per_salvo = this.dao.findById(id);

		
		
	
		
		
		Assert.assertEquals(per_salvo.getNome(),persona.getNome());
		Assert.assertEquals(per_salvo.getClasse().getId(),persona.getClasse().getId());
		Assert.assertEquals(per_salvo.getUsuario().getId(),persona.getUsuario().getId());
		Assert.assertEquals(per_salvo.getMesa().getId(),persona.getMesa().getId());
		Assert.assertEquals(per_salvo.getLvl(),persona.getLvl());
		
		Assert.assertEquals(per_salvo.getForc(),persona.getForc());
		Assert.assertEquals(per_salvo.getDest(),persona.getDest());
		Assert.assertEquals(per_salvo.getCons(),persona.getCons());
		Assert.assertEquals(per_salvo.getInte(),persona.getInte());
		Assert.assertEquals(per_salvo.getSabe(),persona.getSabe());
		Assert.assertEquals(per_salvo.getCari(),persona.getCari());
		
		
		Assert.assertEquals(per_salvo.getFort(),persona.getFort());
		Assert.assertEquals(per_salvo.getRefl(),persona.getRefl());
		Assert.assertEquals(per_salvo.getVont(),persona.getVont());
	
		
		Assert.assertEquals(per_salvo.getHP(),persona.getHP());
		Assert.assertEquals(per_salvo.getCa(),persona.getCa());
		Assert.assertEquals(per_salvo.getBba(),persona.getBba());

	}

	@Test
	public void testupdate() {
		Personagem persona = new Personagem(null, "Darius",
				usu_sal.get(1), cla_all.get(1), 5L, 12L, 14L, 12L, 22L, 14L, 12L, mes_all.get(1));
			
			Long id=  this.dao.save(persona);
		Personagem per_salvo = this.dao.findById(id);
		//mudar de usuario
		per_salvo.setUsuario(usu_sal.get(0));

		this.dao.update(per_salvo);
		Assert.assertEquals(usu_sal.get(0).getId(), per_salvo.getUsuario().getId());
		Assert.assertEquals(id, per_salvo.getId());
		
		//level up
		per_salvo = this.dao.findById(id);
		per_salvo.setLvl(per_salvo.getLvl()+1);
		this.dao.update(per_salvo);
		Long i = 6L;
		Assert.assertEquals(id, per_salvo.getId());
		Assert.assertEquals(i, per_salvo.getLvl());
	}
	@Test
	public void testdelete() {
		Personagem persona = new Personagem(null, "Darius",
				usu_sal.get(1), cla_all.get(1), 5L, 12L, 14L, 12L, 22L, 14L, 12L, mes_all.get(1));
			
			Long id=  this.dao.save(persona);
								
		this.dao.delete(id);
		Personagem persona_del = this.dao.findById(id);
		Assert.assertNull(persona_del);
	}
//	@Test
	public void testall() {
		Personagem persona = new Personagem(null, "Darius",
				usu_sal.get(1), cla_all.get(1), 5L, 12L, 14L, 12L, 22L, 14L, 12L, mes_all.get(1));
		
		Personagem persona2 = new Personagem(null, "Deruwyin",
				usu_sal.get(0), cla_all.get(2), 5L, 8L, 20L, 4L, 22L, 18L, 18L, mes_all.get(1));
		
		Personagem persona3 = new Personagem(null, "Arien",
				usu_sal.get(2), cla_all.get(1), 5L, 14L, 10L, 18L, 14L, 18L, 18L, mes_all.get(1));
		
		
		this.dao.save(persona);
		this.dao.save(persona2);
		this.dao.save(persona3);
		
		List<Personagem> per_all = this.dao.findAll();
		
		
		Assert.assertEquals(per_all.get(0).getNome(),persona.getNome());
		Assert.assertEquals(per_all.get(0).getClasse().getId(),persona.getClasse().getId());
		Assert.assertEquals(per_all.get(0).getUsuario().getId(),persona.getUsuario().getId());
		Assert.assertEquals(per_all.get(0).getMesa().getId(),persona.getMesa().getId());
		Assert.assertEquals(per_all.get(0).getLvl(),persona.getLvl());
		
		Assert.assertEquals(per_all.get(0).getForc(),persona.getForc());
		Assert.assertEquals(per_all.get(0).getDest(),persona.getDest());
		Assert.assertEquals(per_all.get(0).getCons(),persona.getCons());
		Assert.assertEquals(per_all.get(0).getInte(),persona.getInte());
		Assert.assertEquals(per_all.get(0).getSabe(),persona.getSabe());
		Assert.assertEquals(per_all.get(0).getCari(),persona.getCari());
		
		
		Assert.assertEquals(per_all.get(0).getFort(),persona.getFort());
		Assert.assertEquals(per_all.get(0).getRefl(),persona.getRefl());
		Assert.assertEquals(per_all.get(0).getVont(),persona.getVont());
	
		
		Assert.assertEquals(per_all.get(0).getHP(),persona.getHP());
		Assert.assertEquals(per_all.get(0).getCa(),persona.getCa());
		Assert.assertEquals(per_all.get(0).getBba(),persona.getBba());
		

		Assert.assertEquals(per_all.get(1).getNome(),persona2.getNome());
		Assert.assertEquals(per_all.get(1).getClasse().getId(),persona2.getClasse().getId());
		Assert.assertEquals(per_all.get(1).getUsuario().getId(),persona2.getUsuario().getId());
		Assert.assertEquals(per_all.get(1).getMesa().getId(),persona2.getMesa().getId());
		Assert.assertEquals(per_all.get(1).getLvl(),persona2.getLvl());
		
		Assert.assertEquals(per_all.get(1).getForc(),persona2.getForc());
		Assert.assertEquals(per_all.get(1).getDest(),persona2.getDest());
		Assert.assertEquals(per_all.get(1).getCons(),persona2.getCons());
		Assert.assertEquals(per_all.get(1).getInte(),persona2.getInte());
		Assert.assertEquals(per_all.get(1).getSabe(),persona2.getSabe());
		Assert.assertEquals(per_all.get(1).getCari(),persona2.getCari());
		
		
		Assert.assertEquals(per_all.get(1).getFort(),persona2.getFort());
		Assert.assertEquals(per_all.get(1).getRefl(),persona2.getRefl());
		Assert.assertEquals(per_all.get(1).getVont(),persona2.getVont());
	
		
		Assert.assertEquals(per_all.get(1).getHP(),persona2.getHP());
		Assert.assertEquals(per_all.get(1).getCa(),persona2.getCa());
		Assert.assertEquals(per_all.get(1).getBba(),persona2.getBba());
		
		
		for (Personagem i : per_all){
		System.out.println(i);
		}
	}
	@Test
	public void testbyid() {
		Personagem persona = new Personagem(null, "Darius",
				usu_sal.get(1), cla_all.get(1), 5L, 12L, 14L, 12L, 22L, 14L, 12L, mes_all.get(1));
		
		Personagem persona2 = new Personagem(null, "Deruwyin",
				usu_sal.get(0), cla_all.get(2), 5L, 8L, 20L, 4L, 22L, 18L, 18L, mes_all.get(0));
		
		Personagem persona3 = new Personagem(null, "Arien",
				usu_sal.get(2), cla_all.get(1), 5L, 14L, 10L, 18L, 14L, 18L, 18L, mes_all.get(1));
		
		Personagem persona4 = new Personagem(null, "Aine",
				usu_sal.get(2), cla_all.get(2), 5L, 14L, 10L, 18L, 14L, 18L, 18L, mes_all.get(1));
		this.dao.save(persona);
		this.dao.save(persona2);
		this.dao.save(persona3);
		this.dao.save(persona4);		
		List<Personagem> per_all = this.dao.findByUsuario(usu_sal.get(2).getId());
		List<Personagem> per_mesa = this.dao.findByMesa(mes_all.get(1).getId());
		
		Assert.assertEquals(per_all.get(0).getNome(),persona3.getNome());
		Assert.assertEquals(per_all.get(0).getClasse().getId(),persona3.getClasse().getId());
		Assert.assertEquals(per_all.get(0).getUsuario().getId(),persona3.getUsuario().getId());
		Assert.assertEquals(per_all.get(0).getMesa().getId(),persona3.getMesa().getId());
		Assert.assertEquals(per_all.get(0).getLvl(),persona3.getLvl());
				
		Assert.assertEquals(per_all.get(0).getForc(),persona3.getForc());
		Assert.assertEquals(per_all.get(0).getDest(),persona3.getDest());
		Assert.assertEquals(per_all.get(0).getCons(),persona3.getCons());
		Assert.assertEquals(per_all.get(0).getInte(),persona3.getInte());
		Assert.assertEquals(per_all.get(0).getSabe(),persona3.getSabe());
		Assert.assertEquals(per_all.get(0).getCari(),persona3.getCari());
	
		
		Assert.assertEquals(per_all.get(0).getFort(),persona3.getFort());
		Assert.assertEquals(per_all.get(0).getRefl(),persona3.getRefl());
		Assert.assertEquals(per_all.get(0).getVont(),persona3.getVont());
	
		
		Assert.assertEquals(per_all.get(0).getHP(),persona3.getHP());
		Assert.assertEquals(per_all.get(0).getCa(),persona3.getCa());
		Assert.assertEquals(per_all.get(0).getBba(),persona3.getBba());
		
		
		//for (Personagem i : per_mesa){		System.out.println(i);		}
	}
}
