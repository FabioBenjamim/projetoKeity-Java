package com.agendamento.consulta.agenda.api.dto;

import java.util.Date;

import javax.persistence.Column;

import com.agendamento.consulta.util.DiaDaSemanaEnum;

public class JornadaDeTrabalhoDTO {

	private String diaDaSemana;
	private String inicioExpediente;
	private String fimExpediente;
	
	public JornadaDeTrabalhoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public JornadaDeTrabalhoDTO(String diaDaSemana, String inicioExpediente, String fimExpediente) {
		super();
		this.diaDaSemana = diaDaSemana;
		this.inicioExpediente = inicioExpediente;
		this.fimExpediente = fimExpediente;
	}

	public String getDiaDaSemana() {
		return diaDaSemana;
	}
	
	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public String getInicioExpediente() {
		return inicioExpediente;
	}

	public void setInicioExpediente(String inicioExpediente) {
		this.inicioExpediente = inicioExpediente;
	}

	public String getFimExpediente() {
		return fimExpediente;
	}

	public void setFimExpediente(String fimExpediente) {
		this.fimExpediente = fimExpediente;
	}

}
