package br.edu.unifei.ecoe18.supernatural.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class Lugar implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3919411553431398111L;
	@Id
	@GeneratedValue
	private int lugarId;
	private int numSeres;
	private String descricao;
	
	
}
