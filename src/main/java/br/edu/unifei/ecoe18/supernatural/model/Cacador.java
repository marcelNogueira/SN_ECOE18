package br.edu.unifei.ecoe18.supernatural.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Cacador extends Natural {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4677451487175183325L;
	private Boolean ativo;
	private int numCacadas;
	
//	public void cacar() {
//		chamarCacada();
//	}

}
