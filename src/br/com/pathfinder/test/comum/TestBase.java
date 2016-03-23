package br.com.pathfinder.test.comum;

import org.junit.After;
import org.junit.BeforeClass;


import br.com.pathfinder.api.entity.Usuario;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ContextSpecifier;
import br.com.spektro.minispring.core.liquibaseRunner.LiquibaseRunnerService;
import br.com.spektro.minispring.core.query.QueryExecutorService;

public class TestBase {

	@BeforeClass
	public static void setUp() {
		ContextSpecifier.setContext("br.com.pathfinder");
		ConfigDBMapper.setDefaultConnectionName("test");
		LiquibaseRunnerService.run();
	}

	@After
	public void setDown() {
		QueryExecutorService.executeQuery("DELETE FROM " + Usuario.TABLE);
		QueryExecutorService.executeQuery("ALTER SEQUENCE SEQ_PATHFINDER_USUARIO RESTART WITH 1");
		;
	}

}
