package br.com.pathfinder.test.comum;

import java.util.List;

import org.junit.Before;

import br.com.pathfinder.api.dao.ClasseDAO;
import br.com.pathfinder.api.dao.MesaDAO;
import br.com.pathfinder.api.dao.PersonagemDAO;
import br.com.pathfinder.api.dao.UsuarioDAO;
import br.com.pathfinder.api.dto.ClasseDTO;
import br.com.pathfinder.api.dto.MesaDTO;
import br.com.pathfinder.api.dto.PersonagemDTO;
import br.com.pathfinder.api.dto.UsuarioDTO;
import br.com.pathfinder.api.entity.Classe;
import br.com.pathfinder.api.entity.Mesa;
import br.com.pathfinder.api.entity.Usuario;
import br.com.pathfinder.api.service.PersonagemService;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public abstract class Cenario  extends TestBase{
	private UsuarioDAO usr;
	private MesaDAO mes;
	private ClasseDAO cla;
	private PersonagemDAO per;
	
	private UsuarioDTO usrdto;
	private MesaDTO mesdto;
	private ClasseDTO cladto;
	private PersonagemDTO perdto;
	
	private PersonagemService perser;
	
	List<Usuario> usu_sal ;
	List<Mesa> mes_all ;
	List<Classe> cla_all ;
	
	
	@Before
	public void config() {
		this.usr = ImplFinder.getImpl(UsuarioDAO.class);
		this.mes = ImplFinder.getImpl(MesaDAO.class);
		this.cla = ImplFinder.getImpl(ClasseDAO.class);
		this.per = ImplFinder.getImpl(PersonagemDAO.class);
		
		Usuario usu_salvar = new Usuario(null, "Kim", "Miyahara", "tenchu3");
		Usuario usu_salvar2 = new Usuario(null, "Kazuo", "Miyahara2", "senha");
		Usuario usu_salvar3 = new Usuario(null, "Miki", "Karen", "senha2");
		
		usr.save(usu_salvar);
		usr.save(usu_salvar2);
		usr.save(usu_salvar3);
		
		usu_sal= this.usr.findAll();		
		
		Mesa mes_salvar = new Mesa(null, "Mesa1", usu_sal.get(1).getId());
		Mesa mes_salvar2 = new Mesa(null, "Mesa2", usu_sal.get(0).getId());
		Mesa mes_salvar3 = new Mesa(null, "Mesa3", usu_sal.get(2).getId());
		
		
		mes.save(mes_salvar);
		mes.save(mes_salvar2);
		mes.save(mes_salvar3);
		
		mes_all= this.mes.findAll();
		
		Classe cla_salvar = new Classe(null, "Guerreiro",4L,2L,1L,1L,10L);

		Classe cla_salvar2 = new Classe(null, "Ladino",3L,1L,2L,1L,6L);
		Classe cla_salvar3 = new Classe(null, "Mago",2L,1L,1L,2L,4L);

		cla.save(cla_salvar);
		cla.save(cla_salvar2);
		cla.save(cla_salvar3);
		
	
		
		cla_all= this.cla.findAll();
	}
	
	
}
