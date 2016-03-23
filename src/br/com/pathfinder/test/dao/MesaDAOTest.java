package br.com.pathfinder.test.dao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import org.junit.Assert;

import br.com.pathfinder.api.dao.MesaDAO;
import br.com.pathfinder.api.entity.Mesa;
import br.com.pathfinder.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class MesaDAOTest extends TestBase {

	private MesaDAO dao;

	@Before
	public void config() {		this.dao = ImplFinder.getImpl(MesaDAO.class);	}

	@Test
	public void salvar() {}
}
