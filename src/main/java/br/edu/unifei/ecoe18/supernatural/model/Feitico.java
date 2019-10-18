package br.edu.unifei.ecoe18.supernatural.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Feitico implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6986434977024079437L;
	@Id
	@GeneratedValue
	private int feiticoId;
	private String descricao;
	private int poder;
	@ManyToMany
	private List<Ingrediente> ingredientes = new ArrayList<>();

}
