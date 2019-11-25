package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.AnjoDAO;
import br.edu.unifei.ecoe18.supernatural.dao.ArmaDAO;
import br.edu.unifei.ecoe18.supernatural.dao.HabilidadeDAO;
import br.edu.unifei.ecoe18.supernatural.dao.LugarDAO;
import br.edu.unifei.ecoe18.supernatural.dao.RitualDAO;
import br.edu.unifei.ecoe18.supernatural.model.Anjo;
import br.edu.unifei.ecoe18.supernatural.model.Arma;
import br.edu.unifei.ecoe18.supernatural.model.Habilidade;
import br.edu.unifei.ecoe18.supernatural.model.Lugar;
import br.edu.unifei.ecoe18.supernatural.model.NivelEnum;
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
	private List<Anjo> anjos = adao.findAll();
	private String anjoKey;
	
	//extends Ser
	private StatusEnum[] statusSer = StatusEnum.values();
	private LugarDAO lugarDao = new LugarDAO();
	private Integer lugarId;
	private List<Lugar> lugares = lugarDao.findAll();
	private RitualDAO ritualDao = new RitualDAO();
	private List<Ritual> rituais = ritualDao.findAll();
	private ArmaDAO armaDao = new ArmaDAO();
	private List<Arma> armas = armaDao.findAll();
	
	//extends Sobrenatural
	private HabilidadeDAO habilidadeDao = new HabilidadeDAO();
	private List<Habilidade> habilidades = habilidadeDao.findAll();
	
	private NivelEnum[] niveis = NivelEnum.values();
	
	public String inserir() {
		if(lugarId!=null) {
			anjo.setLugar(lugarDao.find(lugarId));		
		}
		try {
			adao.create(anjo);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("j� existe nome"));	
			return "inserir";
		}
		
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
		if(lugarId!=null) {
			anjo.setLugar(lugarDao.find(lugarId));		
		}
		try {
			adao.update(anjo);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("j� existe nome"));	
			return "inserir";
		}
		
		return "/index";
	}
	public String excluir() {
		adao.deleteKey(anjoKey);
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
