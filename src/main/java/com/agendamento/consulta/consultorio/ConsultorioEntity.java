package com.agendamento.consulta.consultorio;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.agendamento.consulta.agenda.AgendaEntity;
import com.agendamento.consulta.medico.MedicoEntity;

@Entity
@Table(name = "CONSULTORIOS")
public class ConsultorioEntity {

	public ConsultorioEntity() {

	}

	public void atualizar(ConsultorioEntity consultorio) {
		this.pontoReferencia = consultorio.getPontoReferencia();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConsultorio;

	@Column
	private String nomeConsultorio;

	@Column
	private String endereco;

	@Column
	private String numero;

	@Column
	private String pontoReferencia;
	
	@Column
	private String lat;
	
	@Column
	private String lng;

	@OneToMany
	@JoinTable(name = "CONSULTORIO_AGENDA", joinColumns = {
			@JoinColumn(name = "idConsultorio") }, inverseJoinColumns = { @JoinColumn(name = "idAgenda") })
	private Set<AgendaEntity> agenda;

	public Long getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(Long idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public String getNomeConsultorio() {
		return nomeConsultorio;
	}

	public void setNomeConsultorio(String nomeConsultorio) {
		this.nomeConsultorio = nomeConsultorio;
	}

	public Set<AgendaEntity> getAgenda() {
		return agenda;
	}

	public void setAgenda(Set<AgendaEntity> agenda) {
		this.agenda = agenda;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

}
