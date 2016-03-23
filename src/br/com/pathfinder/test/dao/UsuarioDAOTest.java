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
	public void config() {		this.dao = ImplFinder.getImpl(UsuarioDAO.class);	}

	@Test
	public void salvar() {
		Usuario usu_salvar = new Usuario(null, "Kim", "Miyahara", "tenchu3");
		usu_salvar.setNome("Kim");
		usu_salvar.setLogin("Miyahara");
		usu_salvar.setSenha("tenchu3");

		Long id = this.dao.save(usu_salvar);

		Usuario usu_salvo = this.dao.findById(id);

		Assert.assertNotNull(usu_salvo);
		Assert.assertEquals("Kim", usu_salvo.getNome());
		Assert.assertEquals("Miyahara", usu_salvo.getLogin());
		Assert.assertEquals("tenchu3", usu_salvo.getSenha());
	}

}
