package br.com.pathfinder.test.dto;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.pathfinder.api.dao.MesaDAO;
import br.com.pathfinder.api.dao.UsuarioDAO;
import br.com.pathfinder.api.dto.MesaDTO;
import br.com.pathfinder.api.dto.UsuarioDTO;
import br.com.pathfinder.api.entity.Mesa;
import br.com.pathfinder.api.entity.Usuario;
import br.com.pathfinder.core.dto.ConversorMesa;
import br.com.pathfinder.core.service.MesaServiceImpl;
import br.com.pathfinder.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class MesaDTOSTest extends TestBase {
	private UsuarioDAO usr;
	private MesaDAO dao;
		
	private ConversorMesa mescon;
	List<Usuario> usu_sal ;
	
	private MesaServiceImpl messer;
	
	@Before
	public void config() {
		this.usr = ImplFinder.getImpl(UsuarioDAO.class);
		this.dao = ImplFinder.getImpl(MesaDAO.class);
		
		
		this.mescon = ImplFinder.getFinalImpl(ConversorMesa.class);
		this.messer = ImplFinder.getFinalImpl(MesaServiceImpl.class);
		
		Usuario usu_salvar = new Usuario(null, "Kim", "Miyahara", "tenchu3");
		Usuario usu_salvar2 = new Usuario(null, "Kazuo", "Miyahara2", "senha");
		Usuario usu_salvar3 = new Usuario(null, "Miki", "Karen", "senha2");
		
		usr.save(usu_salvar);
		usr.save(usu_salvar2);
		usr.save(usu_salvar3);
		
		usu_sal= this.usr.findAll();
	}
	

	@Test
	public void testSave() {
		Mesa mes_salvar = new Mesa(null, "Miya",usu_sal.get(0).getId());
		
		Long id2 = this.dao.save(mes_salvar);
		
		Mesa mes_salvo = this.dao.findById(id2);
		
		MesaDTO mes_dto = this.mescon.toDTO(mes_salvo);
		
		Assert.assertNotNull(mes_dto);
		
		Assert.assertEquals("Miya", mes_dto.getNome());
		Assert.assertEquals(usu_sal.get(0).getId(), mes_dto.getMestre());
	//	System.out.println(mes_dto);

	}

	@Test
	public void testupdate() {
		Mesa mes_old = new Mesa(null, "Miyab",usu_sal.get(1).getId());

		Long id = this.dao.save(mes_old);
		MesaDTO mes_dto = this.mescon.toDTO(mes_old);
		
		Mesa mes_new = this.dao.findById(id) ;
		
		mes_new.setNome("Mesa");
		mes_new.setMestre(usu_sal.get(2).getId());
		MesaDTO mes_dto_new = this.mescon.toDTO(mes_new);
		this.messer.update(mes_dto_new);

	
		Assert.assertEquals("Mesa", mes_dto_new.getNome());
		Assert.assertEquals(usu_sal.get(2).getId(), mes_dto_new.getMestre());
	}



	@Test
	public void testdelete() {
		Mesa mes_salvo = new Mesa(null, "Miyahara",usu_sal.get(1).getId());
		Long id = this.messer.save(mescon.toDTO(mes_salvo));
								
		this.messer.delete(id);
		MesaDTO usu_deletar = this.messer.findById(id);
		Assert.assertNull(usu_deletar);
	}
	@Test
	public void testfindall() {
		Mesa mes_salvar = new Mesa(null, "Mesa1", usu_sal.get(1).getId());
		Mesa mes_salvar2 = new Mesa(null, "Mesa2", usu_sal.get(0).getId());
		Mesa mes_salvar3 = new Mesa(null, "Mesa3", usu_sal.get(2).getId());

		this.messer.save(mescon.toDTO(mes_salvar));
		this.messer.save(mescon.toDTO(mes_salvar2));
		this.messer.save(mescon.toDTO(mes_salvar3));
		
		List<MesaDTO> mesas = this.messer.findAll();
		
		Assert.assertEquals(3, mesas.size());
		Assert.assertEquals("Mesa1", mesas.get(0).getNome());
		Assert.assertEquals(usu_sal.get(1).getId(), mesas.get(0).getMestre());
		Assert.assertEquals("Mesa2", mesas.get(1).getNome());
		Assert.assertEquals(usu_sal.get(0).getId(), mesas.get(1).getMestre());
		Assert.assertEquals("Mesa3", mesas.get(2).getNome());
		Assert.assertEquals(usu_sal.get(2).getId(), mesas.get(2).getMestre());


		
		List<MesaDTO> mes_salvo = this.messer.findByMestre(usu_sal.get(0).getId());
		
		Assert.assertEquals(1, mes_salvo.size());
		Assert.assertEquals("Mesa2", mes_salvo.get(0).getNome());
		Assert.assertEquals(usu_sal.get(0).getId(), mes_salvo.get(0).getMestre());
		
	}

}
