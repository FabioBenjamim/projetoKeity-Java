package com.agendamento.consulta.horario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.agendamento.consulta.agenda.JornadaDeTrabalhoEntity;
import com.agendamento.consulta.util.StatusEnum;

@Entity
@Table(name = "HORARIOS")
public class horarioEntity {
	
	public horarioEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public horarioEntity(JornadaDeTrabalhoEntity jornada, String horario,
			String nomePaciente) {
		super();
		this.jornada = jornada;
		this.horario = horario;
		this.status = "LIVRE";
		this.nomePaciente = nomePaciente;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHorario;
	
	@ManyToOne
	@JoinColumn(name = "JORNADA")
	private JornadaDeTrabalhoEntity jornada;
	
	@Column
	private String horario;
	
	@Column
	private String status;
	
	@Column
	private String nomePaciente;
	
	@Column
	private String consultaRealizada;
	
	@Column(name = "id_paciente")
	private Long idPaciente;
	
	public String getConsultaRealizada() {
		return consultaRealizada;
	}
	
	public void setConsultaRealizada(String consultaRealizada) {
		this.consultaRealizada = consultaRealizada;
	}
	
	public Long getIdPaciente() {
		return idPaciente;
	}
	
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	public Long getIdHorario() {
		return idHorario;
	}
	
	public void setIdHorario(Long idHorario) {
		this.idHorario = idHorario;
	}
	
	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public JornadaDeTrabalhoEntity getJornada() {
		return jornada;
	}
	
	public void setJornada(JornadaDeTrabalhoEntity jornada) {
		this.jornada = jornada;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getNomePaciente() {
		return nomePaciente;
	}
	
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

}
