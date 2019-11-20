package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.CacadaDAO;
import br.edu.unifei.ecoe18.supernatural.model.Cacada;
import lombok.Data;

@Data
@Named(value="cacadaBean")
@RequestScoped
public class CacadaBean implements Serializable {
	private static final long serialVersionUID = -5157180275577962051L;
	private Cacada cacada = new Cacada(); 
	private CacadaDAO cdao = new CacadaDAO(); 
	public String inserir() {
		cdao.create(cacada);
		return "/index";
	}
	public String buscarConsultar() {
		cacada = cdao.find(cacada.getEnventoId());
		if(cacada==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		cacada = cdao.find(cacada.getEnventoId());
		if(cacada==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		cacada = cdao.find(cacada.getEnventoId());
		if(cacada==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		cdao.update(cacada);
		return "/index";
	}
	public String excluir() {
		cdao.deleteKey(cacada.getEnventoId());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
