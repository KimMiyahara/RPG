package br.com.pathfinder.test.dao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import org.junit.Assert;

import br.com.pathfinder.api.dao.UsuarioDAO;
import br.com.pathfinder.api.entity.Usuario;
import br.com.pathfinder.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class UsuarioDAOTest extends TestBase {

	private UsuarioDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(UsuarioDAO.class);
	}
	@Test
	public void testupdate() {
		Usuario usu_salvar = new Usuario(null, "Kim", "Miyahara", "tenchu3");
		Long id = this.dao.save(usu_salvar);
		Usuario usu_new = this.dao.findById(id) ;
		
			usu_new.setNome("Nombre");
			usu_new.setLogin("Log");
			usu_new.setSenha("senha");
								
			this.dao.update(usu_new);
	
		Assert.assertEquals("Nombre", usu_new.getNome());
		Assert.assertEquals("Log", usu_new.getLogin());
		Assert.assertEquals("senha", usu_new.getSenha());
	}

	@Test
	public void testSave() {
		Usuario usu_salvar = new Usuario(null, "Kim", "Miyahara", "tenchu3");
		usu_salvar.setNome("Kim");
		usu_salvar.setLogin("Miyahara");
		usu_salvar.setSenha("tenchu3");

		Long id = this.dao.save(usu_salvar);
		Assert.assertNotNull(id);
		
		Usuario usu_salvo = this.dao.findById(id);
		
		Assert.assertNotNull(usu_salvo);
		Assert.assertEquals("Kim", usu_salvo.getNome());
		Assert.assertEquals("Miyahara", usu_salvo.getLogin());
		Assert.assertEquals("tenchu3", usu_salvo.getSenha());
	}
	@Test
	public void testdelete() {
		Usuario usu_salvar = new Usuario(null, "Kim", "Miyahara", "tenchu3");
		Long id = this.dao.save(usu_salvar);
								
		this.dao.delete(id);
		Usuario usu_deletar = this.dao.findById(id);
		Assert.assertNull(usu_deletar);

	}
	@Test
	public void testfindall() {
		Usuario usu_salvar = new Usuario(null, "Kim", "Miyahara", "tenchu3");
		Usuario usu_salvar2 = new Usuario(null, "Kazuo", "Miyahara2", "senha");
		Usuario usu_salvar3 = new Usuario(null, "Miki", "Karen", "senha2");

		this.dao.save(usu_salvar);
		this.dao.save(usu_salvar2);
		this.dao.save(usu_salvar3);
		
		List<Usuario> usu_salvo = this.dao.findAll();
		
		Assert.assertEquals(3, usu_salvo.size());
		Assert.assertEquals("Kim", usu_salvo.get(0).getNome());
		Assert.assertEquals("Miyahara", usu_salvo.get(0).getLogin());
		Assert.assertEquals("tenchu3", usu_salvo.get(0).getSenha());
		Assert.assertEquals("Kazuo", usu_salvo.get(1).getNome());
		Assert.assertEquals("Miyahara2", usu_salvo.get(1).getLogin());
		Assert.assertEquals("senha", usu_salvo.get(1).getSenha());
		Assert.assertEquals("Karen", usu_salvo.get(2).getLogin());
		Assert.assertEquals("Miki", usu_salvo.get(2).getNome());
		Assert.assertEquals("senha2", usu_salvo.get(2).getSenha());

	}
	
}
