package com.agendamento.consulta.medico.api.dto;

public class MedicoEspecializacoes {
	
	public MedicoEspecializacoes() {
		// TODO Auto-generated constructor stub
	}
	
	public MedicoEspecializacoes(String especializacao) {
		this.especializacao = especializacao;
	}
	
	private String especializacao;

	public String getEspecializacao() {
		return especializacao;
	}
	
	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}
	
}
