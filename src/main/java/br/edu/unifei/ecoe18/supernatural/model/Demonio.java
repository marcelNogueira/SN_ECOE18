package br.edu.unifei.ecoe18.supernatural.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Demonio extends Sobrenatural {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8245750774744787107L;
	private String almaHumana;
	private String corOlhos;
	@Enumerated(EnumType.STRING)
	private NivelEnum nivel;
	
}
