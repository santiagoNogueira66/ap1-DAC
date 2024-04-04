package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import java.util.List;

import DAO.AgendaDao;
import entidades.Agenda;

@ManagedBean
public class AgendamentoBean {

	private Agenda agenda = new Agenda();
	private List<Agenda> lista;
	private long totalAgendamentos;


	public void salvar() {
		AgendaDao.salvar(agenda);
	}

	public void excluir(Agenda agenda) {
		AgendaDao.excluir(agenda);
		lista = null;
	}

	public void editar(RowEditEvent event) {
		Agenda angendaEditada = (Agenda)event.getObject();
		try {
			AgendaDao.editar(angendaEditada);

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "As alterações foram salvas com sucesso."));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
					"Ocorreu um erro ao salvar as alterações: " + e.getMessage()));
		}
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
