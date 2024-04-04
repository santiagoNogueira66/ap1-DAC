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
		 if (existeDuplicata(agenda)) {
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Já existe um agendamento para a mesma data, hora e médico."));
		        return; 
		    }
		AgendaDao.salvar(agenda);
		agenda = new Agenda();
	}

	public void excluir(Agenda agenda) {
		AgendaDao.excluir(agenda);
		lista = null;
	}

	public void editar(RowEditEvent event) {
		Agenda agendaEditada = (Agenda)event.getObject();
		 if (existeDuplicata(agendaEditada)) {
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Já existe um agendamento para a mesma data, hora e médico."));
		        return; 
		    }
		try {
			AgendaDao.editar(agendaEditada);

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

	private boolean existeDuplicata(Agenda agenda) {
	    List<Agenda> agendamentos = AgendaDao.buscarPorDataHoraEMedico(agenda.getDataHoraConsulta(), agenda.getMedico());
	    for (Agenda agendamentoExistente : agendamentos) {
	        if (!agendamentoExistente.getId().equals(agenda.getId())) {
	        	
	            return true; 
	        }
	    }
	    return false; 
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
