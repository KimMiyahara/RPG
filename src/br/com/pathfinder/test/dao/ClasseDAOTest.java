package br.com.pathfinder.test.dao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import org.junit.Assert;

import br.com.pathfinder.api.dao.ClasseDAO;
import br.com.pathfinder.api.entity.Classe;
import br.com.pathfinder.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ClasseDAOTest extends TestBase {

	private ClasseDAO dao;

	@Before
	public void config() {		this.dao = ImplFinder.getImpl(ClasseDAO.class);	}

	@Test
	public void salvar() {}

}
