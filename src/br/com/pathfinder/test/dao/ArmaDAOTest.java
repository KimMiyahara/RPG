package br.com.pathfinder.test.dao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import org.junit.Assert;

import br.com.pathfinder.api.dao.ArmaDAO;
import br.com.pathfinder.api.entity.Arma;
import br.com.pathfinder.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ArmaDAOTest extends TestBase {

	private ArmaDAO dao;

	@Before
	public void config() {		this.dao = ImplFinder.getImpl(ArmaDAO.class);	}

	@Test
	public void salvar() {}

}
