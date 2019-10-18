package br.edu.unifei.ecoe18.supernatural.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Terra extends Lugar {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6922438128071652829L;
	@OneToOne
	private static final Terra instancia = new Terra();
	@Temporal(TemporalType.DATE)
	private Date tempo;
	
	private Terra() {
		// TODO Auto-generated constructor stub
	}
}
