package br.edu.unifei.ecoe18.supernatural.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Criatura extends Sobrenatural {
	private static final long serialVersionUID = -4017439951985932100L;
	private String tipo;
	
}
