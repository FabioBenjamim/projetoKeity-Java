package com.agendamento.consulta.agenda;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.agendamento.consulta.util.DiaDaSemanaEnum;

@Entity
@Table(name = "JORNADADETRABALHO")
public class JornadaDeTrabalhoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idJornada;

	@Column
	private DiaDaSemanaEnum diaDaSemana;

	@Column
	private Date inicioExpediente;

	@Column
	private Date fimExpediente;

	@Column
	private String nomeEscritorio;

	public Long getIdJornada() {
		return idJornada;
	}

	public void setIdJornada(Long idJornada) {
		this.idJornada = idJornada;
	}

	public DiaDaSemanaEnum getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(DiaDaSemanaEnum diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public Date getInicioExpediente() {
		return inicioExpediente;
	}

	public void setInicioExpediente(Date inicioExpediente) {
		this.inicioExpediente = inicioExpediente;
	}

	public Date getFimExpediente() {
		return fimExpediente;
	}

	public void setFimExpediente(Date fimExpediente) {
		this.fimExpediente = fimExpediente;
	}

	public String getNomeEscritorio() {
		return nomeEscritorio;
	}

	public void setNomeEscritorio(String nomeEscritorio) {
		this.nomeEscritorio = nomeEscritorio;
	}

}
