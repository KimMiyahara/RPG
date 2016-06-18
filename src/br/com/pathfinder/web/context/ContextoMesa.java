package br.com.pathfinder.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.pathfinder.api.dto.MesaDTO;
public class ContextoMesa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7036403462389845231L;
	
	private MesaDTO mesa;
	private List<MesaDTO> mesas;
	
	public MesaDTO getMesa() {					return mesa;	}
	public List<MesaDTO> getMesas() {			return mesas;	}
	public void setMesa(MesaDTO mesa) {			this.mesa = mesa;	}
	public void setMesas(List<MesaDTO> mesas) {	this.mesas = mesas;	}

}
