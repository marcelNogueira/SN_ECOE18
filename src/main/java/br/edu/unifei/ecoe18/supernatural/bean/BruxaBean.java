package br.edu.unifei.ecoe18.supernatural.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.unifei.ecoe18.supernatural.dao.ArmaDAO;
import br.edu.unifei.ecoe18.supernatural.dao.BruxaDAO;
import br.edu.unifei.ecoe18.supernatural.dao.EventoDAO;
import br.edu.unifei.ecoe18.supernatural.dao.FeiticoDAO;
import br.edu.unifei.ecoe18.supernatural.dao.HabilidadeDAO;
import br.edu.unifei.ecoe18.supernatural.dao.LugarDAO;
import br.edu.unifei.ecoe18.supernatural.dao.RitualDAO;
import br.edu.unifei.ecoe18.supernatural.model.Arma;
import br.edu.unifei.ecoe18.supernatural.model.Bruxa;
import br.edu.unifei.ecoe18.supernatural.model.Evento;
import br.edu.unifei.ecoe18.supernatural.model.Feitico;
import br.edu.unifei.ecoe18.supernatural.model.Habilidade;
import br.edu.unifei.ecoe18.supernatural.model.Lugar;
import br.edu.unifei.ecoe18.supernatural.model.Ritual;
import br.edu.unifei.ecoe18.supernatural.model.StatusEnum;
import lombok.Data;

@Data
@Named(value="bruxaBean")
@RequestScoped
public class BruxaBean implements Serializable {
	private static final long serialVersionUID = 8256972432863881346L;
	private Bruxa bruxa = new Bruxa(); 
	private BruxaDAO bdao = new BruxaDAO(); 
	private List<Bruxa> bruxas = bdao.findAll();
	
	//extends Ser
	private StatusEnum[] statusSer = StatusEnum.values();
	private EventoDAO eventoDao = new EventoDAO();
	private List<Evento> eventos = eventoDao.findAll();
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
	
	//Bruxa
	private FeiticoDAO fdao = new FeiticoDAO();
	private List<Feitico> feiticos = fdao.findAll();
	
	public String inserir() {
		if(lugarId!=null) {
			bruxa.setLugar(lugarDao.find(lugarId));		
		}
		try {
			bdao.create(bruxa);
		}catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("j� existe nome"));	
			return "inserir";
		}
		
		
		return "/index";
	}
	public String buscarConsultar() {
		bruxa = bdao.find(bruxa.getNome());
		if(bruxa==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "consultar";
		}
	}
	public String buscarAlterar() {
		bruxa = bdao.find(bruxa.getNome());
		if(bruxa==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";			
		}else {
			return "alterar";
		}
	}
	public String buscarExcluir() {
		bruxa = bdao.find(bruxa.getNome());
		if(bruxa==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("n�o encontrado"));
			return "buscar";
		}else {
			return "excluir";
		}
	}
	public String alterar() {
		bdao.update(bruxa);
		return "/index";
	}
	public String excluir() {
		bdao.deleteKey(bruxa.getNome());
		return "/index";
	}
	public String consultar() {
		return "/index";
	}
}
