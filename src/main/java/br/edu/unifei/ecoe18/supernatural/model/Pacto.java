package br.edu.unifei.ecoe18.supernatural.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Pacto extends Evento {
	private static final long serialVersionUID = -5710795874619317693L;
	private String objetivo;
	@OneToOne
	private Natural pessoa;
	@ManyToOne
	private Encruzilhada demonio;
	
//	@Override
//	public void cacada() {
//		// TODO Auto-generated method stub
//
//	}

//	@Override
//	public void pacto() {
//		pessoa.setBondade(0);
//		demonio.setNumPactos(demonio.getNumPactos()+1);
//	}

}
