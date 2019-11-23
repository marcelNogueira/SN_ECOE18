package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.CeuDAO;
import br.edu.unifei.ecoe18.supernatural.model.Ceu;
import lombok.Data;

@Data
@Named(value="ceuBean")
@RequestScoped
public class CeuBean implements Serializable {
	private static final long serialVersionUID = -3234310108455622766L;
	private Ceu ceu = Ceu.getInstancia(); 
	private CeuDAO cdao = new CeuDAO(); 
	private List<Ceu> ceus = cdao.findAll();
	public String inserir() {
		cdao.create(ceu);
		return "/index";
	}
	public String buscarConsultar() {
		ceu = cdao.find(ceu.getLugarId());
		if(ceu==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		ceu = cdao.find(ceu.getLugarId());
		if(ceu==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		ceu = cdao.find(ceu.getLugarId());
		if(ceu==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		cdao.update(ceu);
		return "/index";
	}
	public String excluir() {
		cdao.deleteKey(ceu.getLugarId());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
