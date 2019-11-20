package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.CacadorDAO;
import br.edu.unifei.ecoe18.supernatural.model.Cacador;
import lombok.Data;

@Data
@Named(value="cacadorBean")
@RequestScoped
public class CacadorBean implements Serializable {
	private static final long serialVersionUID = -2012641525716081181L;
	private Cacador cacador = new Cacador(); 
	private CacadorDAO cdao = new CacadorDAO(); 
	public String inserir() {
		cdao.create(cacador);
		return "/index";
	}
	public String buscarConsultar() {
		cacador = cdao.find(cacador.getNome());
		if(cacador==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		cacador = cdao.find(cacador.getNome());
		if(cacador==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		cacador = cdao.find(cacador.getNome());
		if(cacador==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		cdao.update(cacador);
		return "/index";
	}
	public String excluir() {
		cdao.deleteKey(cacador.getNome());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}	
