package br.com.pathfinder.test.dao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import org.junit.Assert;

import br.com.pathfinder.api.dao.EquipamentoDAO;
import br.com.pathfinder.api.entity.Equipamento;
import br.com.pathfinder.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class EquipamentoDAOTest extends TestBase {

	private EquipamentoDAO dao;

	@Before
	public void config() {		this.dao = ImplFinder.getImpl(EquipamentoDAO.class);	}

	@Test
	public void salvar() {}

}
