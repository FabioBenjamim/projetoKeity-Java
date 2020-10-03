package com.agendamento.consulta.agenda.api.dto;

public class AgendaDTO {
	
	private Long idAgenda;
	private JornadaDeTrabalhoDTO semana;
	
	public Long getIdAgenda() {
		return idAgenda;
	}
	
	public void setIdAgenda(Long idAgenda) {
		this.idAgenda = idAgenda;
	}
	
	public JornadaDeTrabalhoDTO getSemana() {
		return semana;
	}
	
	public void setSemana(JornadaDeTrabalhoDTO semana) {
		this.semana = semana;
	}

}
