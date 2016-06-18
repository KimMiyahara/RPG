package br.com.pathfinder.core.service;

import java.util.List;

import br.com.pathfinder.api.dao.MesaDAO;
import br.com.pathfinder.api.dao.PersonagemDAO;
import br.com.pathfinder.api.dao.UsuarioDAO;
import br.com.pathfinder.api.dto.MesaDTO;
import br.com.pathfinder.api.dto.PersonagemDTO;
import br.com.pathfinder.api.dto.UsuarioDTO;
import br.com.pathfinder.api.entity.Personagem;
import br.com.pathfinder.api.entity.Usuario;
import br.com.pathfinder.api.service.UsuarioService;
import br.com.pathfinder.core.dto.ConversorMesa;
import br.com.pathfinder.core.dto.ConversorPersonagem;
import br.com.pathfinder.core.dto.ConversorUsuario;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioDAO usudao;
	private MesaDAO mes;
	private PersonagemDAO persona;
	
	private ConversorUsuario conusu;
	private ConversorMesa conmes;
	private ConversorPersonagem conper;
	
	public UsuarioServiceImpl() {
		this.usudao = ImplFinder.getImpl(UsuarioDAO.class);
		this.mes 	=ImplFinder.getImpl(MesaDAO.class);
		this.persona= ImplFinder.getImpl(PersonagemDAO.class);
		
		this.conusu = ImplFinder.getFinalImpl(ConversorUsuario.class);
		this.conmes	= ImplFinder.getFinalImpl(ConversorMesa.class);
		this.conper = ImplFinder.getFinalImpl(ConversorPersonagem.class);
		
		
	}

	@Override
	public UsuarioDTO save(UsuarioDTO usuarioDTO) {
		Usuario usuario = this.conusu.toEntity(usuarioDTO);
		Long id = this.usudao.save(usuario);
		if (usuarioDTO.getPersonagem()!= null){
			for(PersonagemDTO p: usuarioDTO.getPersonagem()){
				this.persona.save(this.conper.toEntity(p));
			}
		}
		if (usuarioDTO.getMesas()!= null){
			for(MesaDTO  m: usuarioDTO.getMesas()){
				this.mes.save(this.conmes.toEntity(m));
			}
		}
		usuarioDTO.setId(id);
		return usuarioDTO;
	}

	@Override
	public UsuarioDTO update(UsuarioDTO usuarioDTO) {
		Usuario usuario = this.conusu.toEntity(usuarioDTO);
		this.usudao.update(usuario);
		if (usuarioDTO.getPersonagem()!= null){
			for(PersonagemDTO p: usuarioDTO.getPersonagem()){
				this.persona.save(this.conper.toEntity(p));
			}
		}
		if (usuarioDTO.getMesas()!= null){
			for(MesaDTO  m: usuarioDTO.getMesas()){
				this.mes.save(this.conmes.toEntity(m));
			}
		}
		return usuarioDTO;
	}


	@Override
	public void delete(Long id) {
		
		
		this.usudao.delete(id);
		
	}

	@Override
	public UsuarioDTO findById(Long id) {
		Usuario usuario = this.usudao.findById(id);
		return this.conusu.toDTO(usuario);
	}

	@Override
	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = this.usudao.findAll();
		return this.conusu.toDTO(usuarios);
	}

	@Override
	public UsuarioDTO Login(String login, String senha) {
		Usuario usuario = this.usudao.Login(login, senha);
		UsuarioDTO dto = null;
		if (usuario != null) {
			dto = this.conusu.toDTO(usuario);
		}
		return dto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
