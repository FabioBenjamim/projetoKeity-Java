package com.agendamento.consulta.agenda.api.dto;

public class AgendaDTO {
	
	private Long idAgenda;
	private String nomePaciente;
	private JornadaDeTrabalhoDTO semana;
	private Long idMedico;
	
	public Long getIdMedico() {
		return idMedico;
	}
	
	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}
	
	public String getNomePaciente() {
		return nomePaciente;
	}
	
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
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
