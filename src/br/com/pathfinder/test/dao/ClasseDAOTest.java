package br.com.pathfinder.test.dao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import org.junit.Assert;

import br.com.pathfinder.api.dao.ClasseDAO;
import br.com.pathfinder.api.dto.ClasseDTO;
import br.com.pathfinder.api.entity.Classe;
import br.com.pathfinder.api.service.ClasseService;
import br.com.pathfinder.core.dto.ConversorClasse;
import br.com.pathfinder.core.service.ClasseServiceImpl;
import br.com.pathfinder.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ClasseDAOTest extends TestBase {

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
		
		//ClasseDTO cladto = this.claser.save(this.clacon.toDTO(cla_salvar));
		
		
		Assert.assertNotNull(cla_salvo);
		Assert.assertEquals("Guerreiro", cla_salvo.getNome());
		Assert.assertEquals(cla_salvar.getBba(),cla_salvo.getBba());
		Assert.assertEquals(cla_salvar.getFort(),cla_salvo.getFort());
		Assert.assertEquals(cla_salvar.getRefl(),cla_salvo.getRefl());
		Assert.assertEquals(cla_salvar.getVont(),cla_salvo.getVont());
		Assert.assertEquals(cla_salvar.getDado_vida(),cla_salvo.getDado_vida());
	}
	
	@Test
	public void testupdate() {
		Classe cla_old = new Classe(null, "Guerreiro",4L,2L,1L,1L,10L);

		Long id = this.dao.save(cla_old);
			
		Classe cla_new = this.dao.findById(id) ;
		
		Long dce = 12L;
		
		cla_new.setNome("Barbaro");
		cla_new.setDado_vida(12L);

		this.dao.update(cla_new);
	
		Assert.assertEquals("Barbaro", cla_new.getNome());
		Assert.assertEquals(dce, cla_new.getDado_vida());
	}

		@Test
	public void testdelete() {
		Classe cla_salvo = new Classe(null, "Guerreiro",4L,2L,1L,1L,10L);
		Long id = this.dao.save(cla_salvo);
								
		this.dao.delete(id);
		Classe usu_deletar = this.dao.findById(id);
		Assert.assertNull(usu_deletar);
	}
	@Test
	public void testfindall() {
		Classe cla_salvar = new Classe(null, "Guerreiro",4L,2L,1L,1L,10L);
		Classe cla_salvar2 = new Classe(null, "Ladino",3L,1L,2L,1L,6L);
		Classe cla_salvar3 = new Classe(null, "Mago",2L,1L,1L,2L,4L);

		this.dao.save(cla_salvar);
		this.dao.save(cla_salvar2);
		this.dao.save(cla_salvar3);
		
		List<Classe> classes = this.dao.findAll();
		
		Assert.assertEquals(3, classes.size());
		Assert.assertEquals("Guerreiro", classes.get(0).getNome());
		Assert.assertEquals(cla_salvar.getDado_vida(), classes.get(0).getDado_vida());
		Assert.assertEquals("Ladino", classes.get(1).getNome());
		Assert.assertEquals(cla_salvar2.getDado_vida(), classes.get(1).getDado_vida());
		Assert.assertEquals("Mago", classes.get(2).getNome());
		Assert.assertEquals(cla_salvar3.getDado_vida(), classes.get(2).getDado_vida());

	}
}
