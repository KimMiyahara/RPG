package br.com.pathfinder.api.service;

import java.util.List;
import br.com.pathfinder.api.dto.PersonagemDTO;

public interface PersonagemService {

	PersonagemDTO save(PersonagemDTO personagemDTO);
	void update(PersonagemDTO personagemDTO);
	void delete(Long personagemID);
	List<PersonagemDTO> findALL();
	List<PersonagemDTO> findUsuario(Long UsuarioId);
	List<PersonagemDTO> findMesa(Long MesaId);
	PersonagemDTO searchID(Long personagemID);
	
}
