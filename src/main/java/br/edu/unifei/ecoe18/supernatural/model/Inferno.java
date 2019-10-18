package br.edu.unifei.ecoe18.supernatural.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Inferno extends Lugar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5488688314258478470L;
	@OneToOne
	private static final Inferno instancia = new Inferno();
	private String chefe;

	private Inferno() {

	}


}
