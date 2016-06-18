package br.com.pathfinder.core.dto;

import java.util.List;



import com.google.common.collect.Lists;

import br.com.pathfinder.api.dao.MesaDAO;
import br.com.pathfinder.api.dao.PersonagemDAO;
import br.com.pathfinder.api.dto.MesaDTO;
import br.com.pathfinder.api.dto.PersonagemDTO;
import br.com.pathfinder.api.dto.UsuarioDTO;
import br.com.pathfinder.api.entity.Mesa;
import br.com.pathfinder.api.entity.Personagem;
import br.com.pathfinder.api.entity.Usuario;
import br.com.spektro.minispring.core.implfinder.ImplFinder;
import br.com.spektro.minispring.dto.DTOConverter;

public class ConversorUsuario implements DTOConverter<Usuario, UsuarioDTO>{

	private PersonagemDAO perDao;
	private MesaDAO mesDao;
	private ConversorMesa convMes;
	private ConversorPersonagem convPer;
	
	public ConversorUsuario() {
		this.mesDao = ImplFinder.getImpl(MesaDAO.class);
		this.perDao =ImplFinder.getImpl(PersonagemDAO.class);
		this.convMes = ImplFinder.getFinalImpl(ConversorMesa.class);
		this.convPer = ImplFinder.getFinalImpl(ConversorPersonagem.class);
	}
	
	@Override
	public UsuarioDTO toDTO(Usuario usu) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(usu.getId());
		dto.setNome(usu.getNome());
		dto.setSenha(usu.getSenha());
		dto.setLogin(usu.getLogin());
		List<MesaDTO> mes = null;
		List<PersonagemDTO> per = null;
		if (this.mesDao.findAll()==null){
			mes = this.convMes.toDTO(this.mesDao.findAll()); 
		}else{
			//System.out.println("tem coisa");
		//	mes = this.convMes.toDTO(this.mesDao.findByMestre(usu.getId()));
		}
		
		//List<Personagem> per = this.perDao.findPersonagens(usu.getId());
	/*	for (Personagem i: per){
			if (per.contains(i)){
			}else{	per.add(i.getMesa());}
		}
		*/
		dto.setMesas(mes);
		dto.setPersonagens(per);
		
		return dto;
	}

	@Override
	public List<UsuarioDTO> toDTO(List<Usuario> lst) {
		List<UsuarioDTO> dto =  Lists.newArrayList();
		for( Usuario i: lst){
			dto.add(this.toDTO(i));
		}
		return dto;
	}

	@Override
	public Usuario toEntity(UsuarioDTO dto) {
		Usuario usu = new Usuario();
		usu.setId(dto.getId());
		usu.setNome(dto.getNome());
		usu.setLogin(dto.getLogin());
		usu.setSenha(dto.getSenha());
		return usu;
	}

	@Override
	public List<Usuario> toEntity(List<UsuarioDTO> dto) {
		List<Usuario> usu =  Lists.newArrayList();
		for( UsuarioDTO i: dto){
			usu.add(this.toEntity(i));
		}
		return usu;
	}

}
