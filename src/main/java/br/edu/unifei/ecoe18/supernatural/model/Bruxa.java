package br.edu.unifei.ecoe18.supernatural.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Bruxa extends Sobrenatural {
	private static final long serialVersionUID = -1348739053439771516L;
	private int numFeiticos;
	@ManyToMany
	private List<Feitico> feiticos = new ArrayList<>();
	
}
