package com.agendamento.consulta.consultorio;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.agendamento.consulta.medico.MedicoEntity;

@Entity
@Table(name = "CONSULTORIOS")
public class ConsultorioEntity {

	public ConsultorioEntity() {

	}

	public void atualizar(ConsultorioEntity consultorio) {
		this.pontoReferencia = consultorio.getPontoReferencia();
		this.medicos = consultorio.getMedicos();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConsultorio;

	@Column
	private String endereco;

	@Column
	private String numero;

	@Column
	private String pontoReferencia;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CONSULTORIO_MEDICO", joinColumns = {
			@JoinColumn(name = "idConsultorio") }, inverseJoinColumns = { @JoinColumn(name = "idMedico") })
	public List<MedicoEntity> medicos;

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

	public List<MedicoEntity> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<MedicoEntity> medicos) {
		this.medicos = medicos;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

}
