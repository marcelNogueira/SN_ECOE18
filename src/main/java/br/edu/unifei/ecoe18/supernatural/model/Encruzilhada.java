package br.edu.unifei.ecoe18.supernatural.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Encruzilhada extends Demonio {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4595833578519025948L;
	private int numPactos;
	
//	public void fazerPacto() {
//		chamarPacto();
//	}

}
