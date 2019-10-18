package br.edu.unifei.ecoe18.supernatural.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Ceu extends Lugar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8739432852385474597L;
	@OneToOne
	private static final Ceu instancia = new Ceu();
	private String lider;
	
	private Ceu() {
	}

}
