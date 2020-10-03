package com.agendamento.consulta.agenda;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.agendamento.consulta.medico.MedicoEntity;
import com.agendamento.consulta.util.DiaDaSemanaEnum;

@Entity
@Table(name = "AGENDAS")
public class AgendaEntity {
	
	public AgendaEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public AgendaEntity(String nomeConsultorio, MedicoEntity medico) {
		this.nomeConsultorio = nomeConsultorio;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAgenda;
	
	@Column 
	private String nomeConsultorio;
	
	@OneToMany
	@JoinTable(name = "AGENDA_JORNADA", joinColumns = {
			@JoinColumn(name = "idAgenda") }, inverseJoinColumns = { @JoinColumn(name = "idJornada") })
	private List <JornadaDeTrabalhoEntity> semana;
	
	public String getNomeConsultorio() {
		return nomeConsultorio;
	}
	
	public void setNomeConsultorio(String nomeConsultorio) {
		this.nomeConsultorio = nomeConsultorio;
	}
	
	public Long getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(Long idAgenda) {
		this.idAgenda = idAgenda;
	}

	public List<JornadaDeTrabalhoEntity> getSemana() {
		return semana;
	}

	public void setSemana(List<JornadaDeTrabalhoEntity> semana) {
		this.semana = semana;
	}

}
