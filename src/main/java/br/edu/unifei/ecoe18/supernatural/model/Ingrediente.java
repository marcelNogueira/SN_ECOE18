package br.edu.unifei.ecoe18.supernatural.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Ingrediente implements Serializable{
	private static final long serialVersionUID = 135352444182227414L;
	@Id
	private String nome;
	private String quatidade;

}
