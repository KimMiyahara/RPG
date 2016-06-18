package br.com.pathfinder.test.dto;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
import br.com.pathfinder.api.entity.Personagem;
import br.com.pathfinder.api.entity.Usuario;
import br.com.pathfinder.api.service.MesaService;
import br.com.pathfinder.api.service.PersonagemService;
import br.com.pathfinder.api.service.UsuarioService;
import br.com.pathfinder.core.dto.ConversorClasse;
import br.com.pathfinder.core.dto.ConversorMesa;
import br.com.pathfinder.core.dto.ConversorPersonagem;
import br.com.pathfinder.core.dto.ConversorUsuario;
import br.com.pathfinder.core.service.MesaServiceImpl;
import br.com.pathfinder.core.service.UsuarioServiceImpl;
import br.com.pathfinder.test.comum.Cenario;
import br.com.pathfinder.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class UsuarioDTOSTest extends TestBase {
	private UsuarioDAO usr;
	private MesaDAO mes;
	private ClasseDAO cla;
	private PersonagemDAO per;

	
	private ConversorUsuario usrdto;
	private ConversorMesa mesdto;
	private ConversorClasse cladto;
	private ConversorPersonagem perdto;
	
	private UsuarioServiceImpl usrser;
	private MesaServiceImpl messer;
	
	List<UsuarioDTO> usu_sal ;
	List<MesaDTO> mes_all ;
	List<Classe> cla_all ;
	List<PersonagemDTO> per_all ;
	
	
	@Before
	public void config() {
		this.usr = ImplFinder.getImpl(UsuarioDAO.class);
		this.mes = ImplFinder.getImpl(MesaDAO.class);
		this.cla = ImplFinder.getImpl(ClasseDAO.class);
		this.per = ImplFinder.getImpl(PersonagemDAO.class);
		
		this.usrdto = ImplFinder.getFinalImpl(ConversorUsuario.class);
		this.mesdto = ImplFinder.getFinalImpl(ConversorMesa.class);
		this.cladto = ImplFinder.getFinalImpl(ConversorClasse.class);
		this.perdto = ImplFinder.getFinalImpl(ConversorPersonagem.class);
		
		this.messer = ImplFinder.getFinalImpl(MesaServiceImpl.class);
		this.usrser = ImplFinder.getFinalImpl(UsuarioServiceImpl.class);
		
		
		
		
		
		Classe cla_salvar = new Classe(null, "Guerreiro",4L,2L,1L,1L,10L);

		Classe cla_salvar2 = new Classe(null, "Ladino",3L,1L,2L,1L,6L);
		Classe cla_salvar3 = new Classe(null, "Mago",2L,1L,1L,2L,4L);

		cla.save(cla_salvar);
		cla.save(cla_salvar2);
		cla.save(cla_salvar3);
		
		cla_all= this.cla.findAll();
	}
	@Test
	public void testSave() {
		Usuario usu_salvar = new Usuario(null, "Kim", "Miyahara", "tenchu3");
		Usuario usu_salvar2 = new Usuario(null, "Kazuo", "Miyahara2", "senha");
		Usuario usu_salvar3 = new Usuario(null, "Miki", "Karen", "senha2");
		
		
		
		this.usrdto.toDTO(usu_salvar);
		//usrser.save(this.usrdto.toDTO(usu_salvar));
		//usrser.save(this.usrdto.toDTO(usu_salvar2));
		//usrser.save(this.usrdto.toDTO(usu_salvar3));
		//usu_sal= usrser.findAll();
		//System.out.println(usu_sal);
		
		//usu_sal= this.usr.findAll();		
		
		
		/*Mesa mes_salvar = new Mesa(null, "Mesa1", usu_sal.get(1).getId());
		Mesa mes_salvar2 = new Mesa(null, "Mesa2", usu_sal.get(0).getId());
		Mesa mes_salvar3 = new Mesa(null, "Mesa3", usu_sal.get(2).getId());
		
		
		mes.save(mes_salvar);
		mes.save(mes_salvar2);
		mes.save(mes_salvar3);*/
		
		//mes_all= this.mes.findAll();
	
	}
	@Test
	public void testupdate() {
		Usuario usu_salvar = new Usuario(null, "Kim", "Miyahara", "tenchu3");
		Usuario usu_salvar2 = new Usuario(null, "Kazuo", "Miyahara2", "senha");
		Usuario usu_salvar3 = new Usuario(null, "Miki", "Karen", "senha2");
		
		
		
		//this.usrdto.toDTO(usu_salvar);
		  usrser.save(this.usrdto.toDTO(usu_salvar));
		usrser.save(this.usrdto.toDTO(usu_salvar2));
		usrser.save(this.usrdto.toDTO(usu_salvar3));
		usu_sal= usrser.findAll();
		//System.out.println(usu_sal);
		
		
			
		
		
		Mesa mes_salvar = new Mesa(null, "Mesa1", usu_sal.get(0).getId());
		this.mes.save(mes_salvar);
		MesaDTO mesto = mesdto.toDTO(mes_salvar);
		
		mes_all = messer.findAll();
		
		//System.out.println("dto: "+mes_all);
		
		this.usu_sal.get(0).setMesas(mes_all);
		System.out.println(usu_sal.get(0));
		usrser.update(usu_sal.get(0));
		
		usu_sal= usrser.findAll();
		System.out.println(usu_sal);
		
	
	}
	
}
