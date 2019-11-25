package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.ArmaDAO;
import br.edu.unifei.ecoe18.supernatural.model.Arma;
import lombok.Data;

@Data
@Named(value="armaBean")
@RequestScoped
public class ArmaBean implements Serializable {
	private static final long serialVersionUID = 8957482682194094741L;
	private ArmaDAO adao = new ArmaDAO(); 
	private Arma arma = new Arma(); 
	private List<Arma> armas = adao.findAll();
	private String armaKey;
	
	public String inserir() {
		adao.create(arma);
		return "/index";
	}
	public String buscarConsultar() {
		arma = adao.find(arma.getNome());
		if(arma==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		arma = adao.find(arma.getNome());
		if(arma==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		arma = adao.find(arma.getNome());
		if(arma==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		adao.update(arma);
		return "/index";
	}
	public String excluir() {
		adao.deleteKey(armaKey);
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
