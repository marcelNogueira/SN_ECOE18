package br.edu.unifei.ecoe18.supernatural.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Purgatorio extends Lugar {
	private static final long serialVersionUID = -4829470475903357347L;
	@OneToOne
	private static final Purgatorio instancia = new Purgatorio();
	private float latitudePortal;
	private float longitudePortal;

	private Purgatorio() {
		// TODO Auto-generated constructor stub
	}

	public static Purgatorio getInstancia() {
		return instancia;
	}
	
}
