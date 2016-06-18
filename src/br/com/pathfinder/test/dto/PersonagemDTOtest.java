package br.com.pathfinder.test.dto;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.pathfinder.api.dao.ClasseDAO;
import br.com.pathfinder.api.dao.MesaDAO;
import br.com.pathfinder.api.dao.PersonagemDAO;
import br.com.pathfinder.api.dao.UsuarioDAO;
import br.com.pathfinder.api.dto.ClasseDTO;
import br.com.pathfinder.api.dto.MesaDTO;
import br.com.pathfinder.api.dto.PersonagemDTO;
import br.com.pathfinder.api.dto.UsuarioDTO;
import br.com.pathfinder.api.entity.Classe;
import br.com.pathfinder.api.entity.Mesa;
import br.com.pathfinder.api.entity.Personagem;
import br.com.pathfinder.api.entity.Usuario;
import br.com.pathfinder.api.service.PersonagemService;
import br.com.pathfinder.core.dto.ConversorClasse;
import br.com.pathfinder.core.dto.ConversorMesa;
import br.com.pathfinder.core.dto.ConversorPersonagem;
import br.com.pathfinder.core.dto.ConversorUsuario;
import br.com.pathfinder.test.comum.Cenario;
import br.com.pathfinder.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class PersonagemDTOtest extends TestBase  {
	private UsuarioDAO usr;
	private MesaDAO mes;
	private ClasseDAO cla;
	private PersonagemDAO per;
	
	private ConversorUsuario usrdto;
	private ConversorMesa mesdto;
	private ConversorClasse cladto;
	private ConversorPersonagem perdto;
	
	private PersonagemService perser;
	
	List<Usuario> usu_sal ;
	List<Mesa> mes_all ;
	List<Classe> cla_all ;
	List<PersonagemDTO> per_all ;
	
	@Before
	public void config() {
		this.usr = ImplFinder.getImpl(UsuarioDAO.class);
		this.mes = ImplFinder.getImpl(MesaDAO.class);
		this.cla = ImplFinder.getImpl(ClasseDAO.class);
		this.per = ImplFinder.getImpl(PersonagemDAO.class);
		
		this.usrdto = ImplFinder.getFinalImpl(ConversorUsuario.class);
		this.mesdto = ImplFinder.getFinalImpl(ConversorMesa.class);
		this.cladto = ImplFinder.getFinalImpl(ConversorClasse.class);
		this.perdto = ImplFinder.getFinalImpl(ConversorPersonagem.class);
		
		this.perser = ImplFinder.getImpl(PersonagemService.class);
		
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
		
		Long id=  this.per.save(persona);
		Personagem pers= this.per.findById(id);

		PersonagemDTO dto  = new PersonagemDTO(pers.getId(),pers.getNome() ,
				pers.getUsuario(), pers.getClasse(), pers.getLvl(), 
												pers.getForc(), pers.getDest(), pers.getCons(), pers.getInte(),
												pers.getSabe(), pers.getCari(), pers.getMesa());
		this.perser.save(dto);
		Long id2= dto.getId();
		PersonagemDTO dto_saved = this.perser.searchID(id2);
		
		Assert.assertEquals(dto.getNome(),dto_saved.getNome());
		Assert.assertEquals(dto.getClasse().getId(),dto_saved.getClasse().getId());
		Assert.assertEquals(dto.getUsuario().getId(),dto_saved.getUsuario().getId());
		Assert.assertEquals(dto.getMesa().getId(),dto_saved.getMesa().getId());
		Assert.assertEquals(dto.getLvl(),dto_saved.getLvl());
		
		Assert.assertEquals(dto.getForc(),dto_saved.getForc());
		Assert.assertEquals(dto.getDest(),dto_saved.getDest());
		Assert.assertEquals(dto.getCons(),dto_saved.getCons());
		Assert.assertEquals(dto.getInte(),dto_saved.getInte());
		Assert.assertEquals(dto.getSabe(),dto_saved.getSabe());
		Assert.assertEquals(dto.getCari(),dto_saved.getCari());
		
		
		Assert.assertEquals(dto.getFort(),dto_saved.getFort());
		Assert.assertEquals(dto.getRefl(),dto_saved.getRefl());
		Assert.assertEquals(dto.getVont(),dto_saved.getVont());
	
		
		Assert.assertEquals(dto.getHP(),dto_saved.getHP());
		Assert.assertEquals(dto.getCa(),dto_saved.getCa());
		Assert.assertEquals(dto.getBba(),dto_saved.getBba());

	}

	@Test
	public void testupdate() {
		Personagem persona = new Personagem(null, "Darius",
				usu_sal.get(1), cla_all.get(1), 5L, 12L, 14L, 12L, 22L, 14L, 12L, mes_all.get(1));
		
		Long id=  this.per.save(persona);
		Personagem perso= this.per.findById(id);
		//mudar de usuario
		
		PersonagemDTO dto  = new PersonagemDTO(perso.getId(),perso.getNome() ,
				perso.getUsuario(), perso.getClasse(), perso.getLvl(), 
				perso.getForc(), perso.getDest(), perso.getCons(), perso.getInte(),
				perso.getSabe(), perso.getCari(), perso.getMesa());
		this.perser.save(dto);
		
		
		PersonagemDTO pers = this.perser.searchID(id);
		
		pers.setUsuario(usu_sal.get(0));

		this.perser.update(pers);
		Assert.assertEquals(usu_sal.get(0).getId(), pers.getUsuario().getId());
		Assert.assertEquals(id, pers.getId());
		
		//level up
		pers = this.perser.searchID(id);
		pers.setLvl(pers.getLvl()+1);
		this.perser.update(pers);
		Long i = 6L;
		Assert.assertEquals(id, pers.getId());
		Assert.assertEquals(i, pers.getLvl());
		
	}
	@Test
	public void testdelete() {
		Personagem persona = new Personagem(null, "Darius",
				usu_sal.get(1), cla_all.get(1), 5L, 12L, 14L, 12L, 22L, 14L, 12L, mes_all.get(1));
		
		Long id=  this.per.save(persona);
		Personagem perso= this.per.findById(id);

		PersonagemDTO dto  = new PersonagemDTO(perso.getId(),perso.getNome() ,
												perso.getUsuario(), perso.getClasse(), perso.getLvl(), 
												perso.getForc(), perso.getDest(), perso.getCons(), perso.getInte(),
												perso.getSabe(), perso.getCari(), perso.getMesa());
		Long ide = this.perser.save(dto).getId();
		//Long ideletado= dto.getId();
		PersonagemDTO dto_saved = this.perser.searchID(ide);
		this.perser.delete(ide);
		PersonagemDTO dto_saved2 = null;
		dto_saved2 = this.perser.searchID(ide);
		//PersonagemDTO dto_saved2 = this.perser.searchID(ide);
		//System.out.println(dto_saved2);
		//System.out.println(ideletado);
		
		//PersonagemDTO dto_saved = this.perser.searchID(ide);
		Assert.assertNull(dto_saved2);
	}
	
	@Test
	public void testfindmesaeusuario() {
		Personagem persona = new Personagem(null, "Darius",
				usu_sal.get(1), cla_all.get(1), 5L, 12L, 14L, 12L, 22L, 14L, 12L, mes_all.get(1));
		
		Personagem persona2 = new Personagem(null, "Deruwyin",
				usu_sal.get(0), cla_all.get(2), 5L, 8L, 20L, 4L, 22L, 18L, 18L, mes_all.get(1));
		
		Personagem persona3 = new Personagem(null, "Arien",
				usu_sal.get(2), cla_all.get(1), 5L, 14L, 10L, 18L, 14L, 18L, 18L, mes_all.get(1));
		
		
		//this.per.save(persona);
		//this.per.save(persona2);
		//this.per.save(persona3);
		
		
		PersonagemDTO dto  = new PersonagemDTO(persona.getId(),persona.getNome() ,
				persona.getUsuario(), persona.getClasse(), persona.getLvl(), 
				persona.getForc(), persona.getDest(), persona.getCons(), persona.getInte(),
				persona.getSabe(), persona.getCari(), persona.getMesa());
		
		
		PersonagemDTO dto2  = new PersonagemDTO(persona2.getId(),persona2.getNome() ,
				persona2.getUsuario(), persona2.getClasse(), persona2.getLvl(), 
				persona2.getForc(), persona2.getDest(), persona2.getCons(), persona2.getInte(),
				persona2.getSabe(), persona2.getCari(), persona2.getMesa());
		
		
		
		PersonagemDTO dto3  = new PersonagemDTO(persona3.getId(),persona3.getNome() ,
				persona3.getUsuario(), persona3.getClasse(), persona3.getLvl(), 
				persona3.getForc(), persona3.getDest(), persona3.getCons(), persona3.getInte(),
				persona3.getSabe(), persona3.getCari(), persona3.getMesa());
		
		
		this.perser.save(this.perdto.toDTO(persona));
		this.perser.save(this.perdto.toDTO(persona2));
		this.perser.save(this.perdto.toDTO(persona3));
		
		this.per_all = this.perser.findMesa(mes_all.get(1).getId());

				
		Assert.assertEquals(per_all.get(0).getNome(),dto.getNome());
		Assert.assertEquals(per_all.get(0).getClasse().getId(),dto.getClasse().getId());
		Assert.assertEquals(per_all.get(0).getUsuario().getId(),dto.getUsuario().getId());
		Assert.assertEquals(per_all.get(0).getMesa().getId(),dto.getMesa().getId());
		Assert.assertEquals(per_all.get(0).getLvl(),dto.getLvl());
		
		Assert.assertEquals(per_all.get(0).getForc(),dto.getForc());
		Assert.assertEquals(per_all.get(0).getDest(),dto.getDest());
		Assert.assertEquals(per_all.get(0).getCons(),dto.getCons());
		Assert.assertEquals(per_all.get(0).getInte(),dto.getInte());
		Assert.assertEquals(per_all.get(0).getSabe(),dto.getSabe());
		Assert.assertEquals(per_all.get(0).getCari(),dto.getCari());
		
		
		Assert.assertEquals(per_all.get(0).getFort(),dto.getFort());
		Assert.assertEquals(per_all.get(0).getRefl(),dto.getRefl());
		Assert.assertEquals(per_all.get(0).getVont(),dto.getVont());
	
		
		Assert.assertEquals(per_all.get(0).getHP(),dto.getHP());
		Assert.assertEquals(per_all.get(0).getCa(),dto.getCa());
		Assert.assertEquals(per_all.get(0).getBba(),dto.getBba());
		

		Assert.assertEquals(per_all.get(1).getNome(),dto2.getNome());
		Assert.assertEquals(per_all.get(1).getClasse().getId(),dto2.getClasse().getId());
		Assert.assertEquals(per_all.get(1).getUsuario().getId(),dto2.getUsuario().getId());
		Assert.assertEquals(per_all.get(1).getMesa().getId(),dto2.getMesa().getId());
		Assert.assertEquals(per_all.get(1).getLvl(),dto2.getLvl());
		
		Assert.assertEquals(per_all.get(1).getForc(),dto2.getForc());
		Assert.assertEquals(per_all.get(1).getDest(),dto2.getDest());
		Assert.assertEquals(per_all.get(1).getCons(),dto2.getCons());
		Assert.assertEquals(per_all.get(1).getInte(),dto2.getInte());
		Assert.assertEquals(per_all.get(1).getSabe(),dto2.getSabe());
		Assert.assertEquals(per_all.get(1).getCari(),dto2.getCari());
		
		
		Assert.assertEquals(per_all.get(1).getFort(),dto2.getFort());
		Assert.assertEquals(per_all.get(1).getRefl(),dto2.getRefl());
		Assert.assertEquals(per_all.get(1).getVont(),dto2.getVont());
	
		
		Assert.assertEquals(per_all.get(1).getHP(),dto2.getHP());
		Assert.assertEquals(per_all.get(1).getCa(),dto2.getCa());
		Assert.assertEquals(per_all.get(1).getBba(),dto2.getBba());
		
		
		//for (PersonagemDTO i : per_all){		System.out.println(i);		}
		
		this.per_all = this.perser.findUsuario(usu_sal.get(2).getId());
		//for (PersonagemDTO i : per_all){		System.out.println(i);		}
	}
	
	@Test
	public void testfindall() {
		Personagem persona = new Personagem(null, "Darius",
				usu_sal.get(1), cla_all.get(1), 5L, 12L, 14L, 12L, 22L, 14L, 12L, mes_all.get(1));
		
		Personagem persona2 = new Personagem(null, "Deruwyin",
				usu_sal.get(0), cla_all.get(2), 5L, 8L, 20L, 4L, 22L, 18L, 18L, mes_all.get(1));
		
		Personagem persona3 = new Personagem(null, "Arien",
				usu_sal.get(2), cla_all.get(1), 5L, 14L, 10L, 18L, 14L, 18L, 18L, mes_all.get(1));
		
		
		//this.per.save(persona);
		//this.per.save(persona2);
		//this.per.save(persona3);
		
		
		PersonagemDTO dto  = new PersonagemDTO(persona.getId(),persona.getNome() ,
				persona.getUsuario(), persona.getClasse(), persona.getLvl(), 
				persona.getForc(), persona.getDest(), persona.getCons(), persona.getInte(),
				persona.getSabe(), persona.getCari(), persona.getMesa());
		
		
		PersonagemDTO dto2  = new PersonagemDTO(persona2.getId(),persona2.getNome() ,
				persona2.getUsuario(), persona2.getClasse(), persona2.getLvl(), 
				persona2.getForc(), persona2.getDest(), persona2.getCons(), persona2.getInte(),
				persona2.getSabe(), persona2.getCari(), persona2.getMesa());
		
		
		
		PersonagemDTO dto3  = new PersonagemDTO(persona3.getId(),persona3.getNome() ,
				persona3.getUsuario(), persona3.getClasse(), persona3.getLvl(), 
				persona3.getForc(), persona3.getDest(), persona3.getCons(), persona3.getInte(),
				persona3.getSabe(), persona3.getCari(), persona3.getMesa());
		
		
		this.perser.save(this.perdto.toDTO(persona));
		this.perser.save(this.perdto.toDTO(persona2));
		this.perser.save(this.perdto.toDTO(persona3));
		
		this.per_all = this.perser.findALL();

				
		Assert.assertEquals(per_all.get(0).getNome(),dto.getNome());
		Assert.assertEquals(per_all.get(0).getClasse().getId(),dto.getClasse().getId());
		Assert.assertEquals(per_all.get(0).getUsuario().getId(),dto.getUsuario().getId());
		Assert.assertEquals(per_all.get(0).getMesa().getId(),dto.getMesa().getId());
		Assert.assertEquals(per_all.get(0).getLvl(),dto.getLvl());
		
		Assert.assertEquals(per_all.get(0).getForc(),dto.getForc());
		Assert.assertEquals(per_all.get(0).getDest(),dto.getDest());
		Assert.assertEquals(per_all.get(0).getCons(),dto.getCons());
		Assert.assertEquals(per_all.get(0).getInte(),dto.getInte());
		Assert.assertEquals(per_all.get(0).getSabe(),dto.getSabe());
		Assert.assertEquals(per_all.get(0).getCari(),dto.getCari());
		
		
		Assert.assertEquals(per_all.get(0).getFort(),dto.getFort());
		Assert.assertEquals(per_all.get(0).getRefl(),dto.getRefl());
		Assert.assertEquals(per_all.get(0).getVont(),dto.getVont());
	
		
		Assert.assertEquals(per_all.get(0).getHP(),dto.getHP());
		Assert.assertEquals(per_all.get(0).getCa(),dto.getCa());
		Assert.assertEquals(per_all.get(0).getBba(),dto.getBba());
		

		Assert.assertEquals(per_all.get(1).getNome(),dto2.getNome());
		Assert.assertEquals(per_all.get(1).getClasse().getId(),dto2.getClasse().getId());
		Assert.assertEquals(per_all.get(1).getUsuario().getId(),dto2.getUsuario().getId());
		Assert.assertEquals(per_all.get(1).getMesa().getId(),dto2.getMesa().getId());
		Assert.assertEquals(per_all.get(1).getLvl(),dto2.getLvl());
		
		Assert.assertEquals(per_all.get(1).getForc(),dto2.getForc());
		Assert.assertEquals(per_all.get(1).getDest(),dto2.getDest());
		Assert.assertEquals(per_all.get(1).getCons(),dto2.getCons());
		Assert.assertEquals(per_all.get(1).getInte(),dto2.getInte());
		Assert.assertEquals(per_all.get(1).getSabe(),dto2.getSabe());
		Assert.assertEquals(per_all.get(1).getCari(),dto2.getCari());
		
		
		Assert.assertEquals(per_all.get(1).getFort(),dto2.getFort());
		Assert.assertEquals(per_all.get(1).getRefl(),dto2.getRefl());
		Assert.assertEquals(per_all.get(1).getVont(),dto2.getVont());
	
		
		Assert.assertEquals(per_all.get(1).getHP(),dto2.getHP());
		Assert.assertEquals(per_all.get(1).getCa(),dto2.getCa());
		Assert.assertEquals(per_all.get(1).getBba(),dto2.getBba());
		
		
		//for (PersonagemDTO i : per_all){		System.out.println(i);		}
	}
}
