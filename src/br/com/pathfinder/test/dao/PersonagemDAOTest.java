package br.com.pathfinder.test.dao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import org.junit.Assert;

import br.com.pathfinder.api.dao.PersonagemDAO;
import br.com.pathfinder.api.entity.Personagem;
import br.com.pathfinder.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class PersonagemDAOTest extends TestBase {

	private PersonagemDAO dao;

	@Before
	public void config() {		this.dao = ImplFinder.getImpl(PersonagemDAO.class);	}

	@Test
	public void salvar() {}
}
