package br.edu.unifei.ecoe18.supernatural.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Natural extends Ser {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4636682736873912867L;
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	private int bondade;
	
//	public void fazerPacto() {
//		chamarPacto();
//	}

}
