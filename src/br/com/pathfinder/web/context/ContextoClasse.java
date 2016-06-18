package br.com.pathfinder.web.context;

import java.io.Serializable;
import java.util.List;
import br.com.pathfinder.api.dto.ClasseDTO;

public class ContextoClasse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1356408192836606232L;
	private ClasseDTO classe;
	private List<ClasseDTO> classes;
	
	public ClasseDTO getClasse(){			return this.classe;		}
	public List<ClasseDTO> getClasses(){	return this.classes;	}
	public void setClasse(ClasseDTO classe) {			this.classe = classe;		}
	public void setClasses(List<ClasseDTO> classes) {	this.classes = classes;		}
	
}
