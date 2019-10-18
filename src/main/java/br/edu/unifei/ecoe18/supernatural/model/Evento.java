package br.edu.unifei.ecoe18.supernatural.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class Evento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1912875856381085672L;
	@Id
	@GeneratedValue
	private int enventoId;
}
