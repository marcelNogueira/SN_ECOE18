package br.edu.unifei.ecoe18.supernatural.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public abstract class Ser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8094507416501341883L;
	@Id
	private String nome;
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	@ManyToOne
	private Lugar lugar;
	@ManyToMany
	private List<Arma> armas = new ArrayList<>();
	@ManyToMany
	private List<Ritual> rituais = new ArrayList<>();
	@ManyToOne
	private Evento evento;

//	protected void chamarPacto() {
//		evento.pacto();
//	}
//
//	protected void chamarCacada() {
//		evento.cacada();
//	}

//	public void setLugar(Lugar l) {
//		if(lugar != null)
//			lugar.setNumSeres(lugar.getNumSeres()-1);
//		l.setNumSeres(l.getNumSeres()+1);
//		this.lugar = l;
//	}

}
