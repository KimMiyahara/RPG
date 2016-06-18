package br.com.pathfinder.core.service;

import java.util.List;

import br.com.pathfinder.api.dao.MesaDAO;
import br.com.pathfinder.api.dao.PersonagemDAO;
import br.com.pathfinder.api.dto.MesaDTO;
import br.com.pathfinder.api.entity.Mesa;
import br.com.pathfinder.api.entity.Personagem;
import br.com.pathfinder.api.service.MesaService;
import br.com.pathfinder.core.dto.ConversorMesa;
import br.com.pathfinder.core.dto.ConversorPersonagem;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class MesaServiceImpl  implements MesaService{
	private MesaDAO mesdao;
	
private ConversorMesa mescon;
	
	public MesaServiceImpl() {
		
		this.mesdao = ImplFinder.getImpl(MesaDAO.class);
		
		this.mescon = ImplFinder.getFinalImpl(ConversorMesa.class);
	}
	@Override
	public Long save(MesaDTO mesaDTO) {
		Mesa mes = this.mescon.toEntity(mesaDTO);
		if(mesaDTO.getId()!=null){
			this.mesdao.update(mes);
		}else{
			Long id = this.mesdao.save(mes);
			mesaDTO.setId(id);
		}
		return mesaDTO.getId();
	}

	@Override
	public void update(MesaDTO mesaDTO) {
		Mesa mes = this.mescon.toEntity(mesaDTO);
			this.mesdao.update(mes);
	}

	@Override
	public void delete(Long id) {
		this.mesdao.delete(id);
	}

	@Override
	public MesaDTO findById(Long id) {
		Mesa mes = this.mesdao.findById(id);
		if (mes != null){return this.mescon.toDTO(mes);}
		return null;
	}

	@Override
	public List<MesaDTO> findByMestre(Long id) {
		List<Mesa> mesas= this.mesdao.findByMestre(id);
		return this.mescon.toDTO(mesas);
	}

	@Override
	public List<MesaDTO> findAll() {
		List<Mesa> mesas= this.mesdao.findAll();
		return this.mescon.toDTO(mesas);
	}

}
