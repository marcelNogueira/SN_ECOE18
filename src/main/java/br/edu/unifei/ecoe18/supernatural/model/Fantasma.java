package br.edu.unifei.ecoe18.supernatural.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Fantasma extends Sobrenatural {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4406388098854976551L;
	private String objetoConexao;
	private String almaHumana;

}
