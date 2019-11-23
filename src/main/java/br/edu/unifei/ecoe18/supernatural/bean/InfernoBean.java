package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.InfernoDAO;
import br.edu.unifei.ecoe18.supernatural.model.Inferno;
import lombok.Data;

@Data
@Named(value="infernoBean")
@RequestScoped
public class InfernoBean implements Serializable {
	private static final long serialVersionUID = -6482656155979404530L;
	private Inferno inferno = Inferno.getInstancia(); 
	private InfernoDAO idao = new InfernoDAO(); 
	private List<Inferno> infernos = idao.findAll();
	public String inserir() {
		idao.create(inferno);
		return "/index";
	}
	public String buscarConsultar() {
		inferno = idao.find(inferno.getLugarId());
		if(inferno==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		inferno = idao.find(inferno.getLugarId());
		if(inferno==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		inferno = idao.find(inferno.getLugarId());
		if(inferno==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		idao.update(inferno);
		return "/index";
	}
	public String excluir() {
		idao.deleteKey(inferno.getLugarId());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
