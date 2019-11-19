package br.edu.unifei.ecoe18.supernatural.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Cacada extends Evento {
	private static final long serialVersionUID = -2987417941951645446L;
	@OneToMany
	private List<Natural> vitimas = new ArrayList<>();
	@ManyToMany
	private List<Cacador> cacadores = new ArrayList<>();
	@ManyToMany
	private List<Sobrenatural> cacas = new ArrayList<>();
	
//	@Override
//	public void cacada() {
//		for(Natural v: vitimas) {
//			v.setStatus(StatusEnum.FALECIDO);
//			if(v.getBondade() < 40) {
//				v.setLugar(Inferno.getInstancia());
//			}
//			else {
//				v.setLugar(Ceu.getInstancia());
//			}
//		}
//		
//		for(Sobrenatural c: cacas) {
//			if(c instanceof Anjo) {
//				c.setLugar(Ceu.getInstancia());
//			}
//			else if(c instanceof Demonio) {
//				c.setLugar(Inferno.getInstancia());
//			}
//			else {
//				c.setLugar(Purgatorio.getInstancia());
//			}
//		}
//		
//		for(Cacador c: cacadores) c.setNumCacadas(c.getNumCacadas()+1);
//
//	}
//
//	@Override
//	public void pacto() {
//		// TODO Auto-generated method stub
//
//	}

}
