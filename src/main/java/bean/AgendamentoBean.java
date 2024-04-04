package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import DAO.AgendaDao;
import entidades.Agenda;

@ManagedBean
public class AgendamentoBean {
	public AgendamentoBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	private Agenda agenda = new Agenda();
	private List<Agenda>lista;	
	
	public void salvar() {
		AgendaDao.salvar(agenda);
	}
	
	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	

	public List<Agenda> getlista() {
		if(lista == null) {
			lista = AgendaDao.listar();
		}
		return lista;
	}
}
