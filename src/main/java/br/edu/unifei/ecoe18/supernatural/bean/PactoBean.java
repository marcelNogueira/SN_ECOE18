package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.PactoDAO;
import br.edu.unifei.ecoe18.supernatural.model.Pacto;
import lombok.Data;

@Data
@Named(value="pactoBean")
@RequestScoped
public class PactoBean implements Serializable {
	private static final long serialVersionUID = -1987373363461582717L;
	private Pacto pacto = new Pacto(); 
	private PactoDAO pdao = new PactoDAO(); 
	public String inserir() {
		pdao.create(pacto);
		return "/index";
	}
	public String buscarConsultar() {
		pacto = pdao.find(pacto.getEnventoId());
		if(pacto==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		pacto = pdao.find(pacto.getEnventoId());
		if(pacto==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		pacto = pdao.find(pacto.getEnventoId());
		if(pacto==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		pdao.update(pacto);
		return "/index";
	}
	public String excluir() {
		pdao.deleteKey(pacto.getEnventoId());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
