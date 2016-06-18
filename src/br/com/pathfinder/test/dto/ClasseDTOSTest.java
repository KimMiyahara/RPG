package br.com.pathfinder.test.dto;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.pathfinder.api.dao.ClasseDAO;
import br.com.pathfinder.api.dto.ClasseDTO;
import br.com.pathfinder.api.entity.Classe;
import br.com.pathfinder.core.dto.ConversorClasse;
import br.com.pathfinder.core.service.ClasseServiceImpl;
import br.com.pathfinder.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ClasseDTOSTest extends TestBase{
	private ClasseDAO dao;
	private ConversorClasse clacon;
	private ClasseServiceImpl claser;
	
	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(ClasseDAO.class);
		this.clacon = ImplFinder.getFinalImpl(ConversorClasse.class);
		this.claser = ImplFinder.getFinalImpl(ClasseServiceImpl.class);
		
	}
	
	@Test
	public void testSave() {
		Classe cla_salvar = new Classe(null, "Guerreiro",4L,2L,1L,1L,10L);
		
		Long id = this.dao.save(cla_salvar);

		Classe cla_salvo = this.dao.findById(id);
		
		
		ClasseDTO cladto = this.clacon.toDTO(cla_salvar);
		Long ide= this.claser.save(cladto);
		ClasseDTO cladto_salvo = this.claser.findById(ide);

		Assert.assertNotNull(cladto_salvo);
		Assert.assertEquals("Guerreiro", cladto_salvo.getNome());
		Assert.assertEquals(cla_salvar.getBba(),cladto_salvo.getBba());
		Assert.assertEquals(cla_salvar.getFort(),cladto_salvo.getFort());
		Assert.assertEquals(cla_salvar.getRefl(),cladto_salvo.getRefl());
		Assert.assertEquals(cla_salvar.getVont(),cladto_salvo.getVont());
		Assert.assertEquals(cla_salvar.getDado_vida(),cladto_salvo.getDado_vida());
	}
	
	@Test
	public void testupdate() {
		Classe cla_old = new Classe(null, "Guerreiro",4L,2L,1L,1L,10L);

		ClasseDTO cladto = this.clacon.toDTO(cla_old);
		Long ide= this.claser.save(cladto);
		ClasseDTO cladto_salvo = this.claser.findById(ide);
		//System.out.println(cladto_salvo);
		
		Long dce = 12L;
		
		cladto_salvo.setNome("Barbaro");
		cladto_salvo.setDado_vida(12L);

		this.claser.update(cladto_salvo);	
		//this.dao.update(cla_new);
	//System.out.println(cladto_salvo);
		Assert.assertEquals("Barbaro", cladto_salvo.getNome());
		Assert.assertEquals(dce, cladto_salvo.getDado_vida());
	}

		@Test
	public void testdelete() {
			Classe cla_old = new Classe(null, "Guerreiro",4L,2L,1L,1L,10L);

			ClasseDTO cladto = this.clacon.toDTO(cla_old);
			Long ide= this.claser.save(cladto);
			ClasseDTO cladto_salvo = this.claser.findById(ide);
								
			this.claser.delete(ide);
			ClasseDTO cla_deletado = this.claser.findById(ide);
			//System.out.println(cla_deletado);
			Assert.assertNull(cla_deletado);
	}
	@Test
	public void testfindall() {
		Classe cla_salvar = new Classe(null, "Guerreiro",4L,2L,1L,1L,10L);
		Classe cla_salvar2 = new Classe(null, "Ladino",3L,1L,2L,1L,6L);
		Classe cla_salvar3 = new Classe(null, "Mago",2L,1L,1L,2L,4L);

		this.claser.save(this.clacon.toDTO(cla_salvar));
		this.claser.save(this.clacon.toDTO(cla_salvar2));
		this.claser.save(this.clacon.toDTO(cla_salvar3));
		
		List<ClasseDTO> classes = this.claser.findAll();
		
		Assert.assertEquals(3, classes.size());
		Assert.assertEquals("Guerreiro", classes.get(0).getNome());
		Assert.assertEquals(cla_salvar.getDado_vida(), classes.get(0).getDado_vida());
		Assert.assertEquals("Ladino", classes.get(1).getNome());
		Assert.assertEquals(cla_salvar2.getDado_vida(), classes.get(1).getDado_vida());
		Assert.assertEquals("Mago", classes.get(2).getNome());
		Assert.assertEquals(cla_salvar3.getDado_vida(), classes.get(2).getDado_vida());

	}
}
