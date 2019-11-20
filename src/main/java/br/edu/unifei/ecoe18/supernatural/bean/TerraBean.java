package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.TerraDAO;
import br.edu.unifei.ecoe18.supernatural.model.Terra;
import lombok.Data;

@Data
@Named(value="terraBean")
@RequestScoped
public class TerraBean implements Serializable {
	private static final long serialVersionUID = -6684786246390914778L;
	private Terra terra = Terra.getInstancia(); 
	private TerraDAO tdao = new TerraDAO(); 
	public String inserir() {
		tdao.create(terra);
		return "/index";
	}
	public String buscarConsultar() {
		terra = tdao.find(terra.getLugarId());
		if(terra==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		terra = tdao.find(terra.getLugarId());
		if(terra==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		terra = tdao.find(terra.getLugarId());
		if(terra==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		tdao.update(terra);
		return "/index";
	}
	public String excluir() {
		tdao.deleteKey(terra.getLugarId());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
