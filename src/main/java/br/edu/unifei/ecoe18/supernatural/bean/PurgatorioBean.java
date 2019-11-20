package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.PurgatorioDAO;
import br.edu.unifei.ecoe18.supernatural.model.Purgatorio;
import lombok.Data;

@Data
@Named(value="purgatorioBean")
@RequestScoped
public class PurgatorioBean implements Serializable {
	private static final long serialVersionUID = 1287620073192851736L;
	private Purgatorio purgatorio = Purgatorio.getInstancia(); 
	private PurgatorioDAO pdao = new PurgatorioDAO(); 
	public String inserir() {
		pdao.create(purgatorio);
		return "/index";
	}
	public String buscarConsultar() {
		purgatorio = pdao.find(purgatorio.getLugarId());
		if(purgatorio==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		purgatorio = pdao.find(purgatorio.getLugarId());
		if(purgatorio==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		purgatorio = pdao.find(purgatorio.getLugarId());
		if(purgatorio==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		pdao.update(purgatorio);
		return "/index";
	}
	public String excluir() {
		pdao.deleteKey(purgatorio.getLugarId());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
