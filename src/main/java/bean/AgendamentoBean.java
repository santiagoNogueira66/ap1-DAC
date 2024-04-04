package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import DAO.AgendaDao;
import entidades.Agenda;

@ManagedBean
public class AgendamentoBean {
	

	private Agenda agenda = new Agenda();
	private List<Agenda> lista;
	private long totalAgendamentos;
	
	public void salvar() {
		AgendaDao.salvar(agenda);
		Agenda agenda = new Agenda();
	}

	public void excluir(Agenda agenda) {
		AgendaDao.excluir(agenda);
		lista = null;
	}

	
	public void editar(Agenda agenda) {
		AgendaDao.editar(agenda);
	}
	
	public void contar() {
		totalAgendamentos = AgendaDao.contar();
	}

	
	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public List<Agenda> getlista() {
		if (lista == null) {
			lista = AgendaDao.listar();
		}
		return lista;
	}

	public long getTotalAgendamentos() {
		return totalAgendamentos;
	}

	public void setTotalAgendamentos(long totalAgendamentos) {
		this.totalAgendamentos = totalAgendamentos;
	}
	
}
