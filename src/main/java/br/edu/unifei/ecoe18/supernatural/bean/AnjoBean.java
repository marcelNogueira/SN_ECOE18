package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.AnjoDAO;
import br.edu.unifei.ecoe18.supernatural.dao.EventoDAO;
import br.edu.unifei.ecoe18.supernatural.dao.LugarDAO;
import br.edu.unifei.ecoe18.supernatural.dao.RitualDAO;
import br.edu.unifei.ecoe18.supernatural.model.Anjo;
import br.edu.unifei.ecoe18.supernatural.model.Evento;
import br.edu.unifei.ecoe18.supernatural.model.Lugar;
import br.edu.unifei.ecoe18.supernatural.model.Ritual;
import br.edu.unifei.ecoe18.supernatural.model.StatusEnum;
import lombok.Data;

@Data
@Named(value="anjoBean")
@RequestScoped
public class AnjoBean implements Serializable{
	private static final long serialVersionUID = -345610720839907403L;
	private Anjo anjo = new Anjo(); 
	private AnjoDAO adao = new AnjoDAO(); 
	
	private StatusEnum[] statusSer = StatusEnum.values();
	private EventoDAO eventoDao = new EventoDAO();
	private List<Evento> eventos = eventoDao.findAll();
	private LugarDAO lugarDao = new LugarDAO();
	private List<Lugar> lugares = lugarDao.findAll();
	private RitualDAO ritualDao = new RitualDAO();
	private List<Ritual> rituais = ritualDao.findAll();
	
	public String inserir() {
		adao.create(anjo);
		return "/index";
	}
	public String buscarConsultar() {
		anjo = adao.find(anjo.getNome());
		if(anjo==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		anjo = adao.find(anjo.getNome());
		if(anjo==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		anjo = adao.find(anjo.getNome());
		if(anjo==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("não encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		adao.update(anjo);
		return "/index";
	}
	public String excluir() {
		adao.deleteKey(anjo.getNome());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
