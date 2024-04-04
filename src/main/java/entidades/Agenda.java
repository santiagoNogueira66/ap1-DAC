package entidades;


import javax.persistence.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Agenda {
	
	@Id
	@GeneratedValue	
	private Integer id;
	
	@Column(name="paciente", nullable = false, length = 255)
	private String paciente;
	
	@Column (name="medico", nullable = false, length = 255)
	private String medico;
	
	@Column (name="data_hora_consulta", nullable = false, length = 255)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraConsulta;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}
	public Date getDataHoraConsulta() {
		return dataHoraConsulta;
	}
	public void setDataHoraConsulta(Date dataHoraConsulta) {
		this.dataHoraConsulta = dataHoraConsulta;
	}
}
