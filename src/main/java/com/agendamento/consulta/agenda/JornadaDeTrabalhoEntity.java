package com.agendamento.consulta.agenda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	public JornadaDeTrabalhoEntity() {
		// TODO Auto-generated constructor stub
	}

	public JornadaDeTrabalhoEntity(String dia, String inicioExpediente,
			String fimExpediente) throws ParseException {
		super();
		this.dia = dia;
		this.inicioExpediente = inicioExpediente;
		this.fimExpediente = fimExpediente;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idJornada;

	@Column
	private String dia;

	@Column
	private String inicioExpediente;

	@Column
	private String fimExpediente;

	public Long getIdJornada() {
		return idJornada;
	}

	public void setIdJornada(Long idJornada) {
		this.idJornada = idJornada;
	}

	public String getInicioExpediente() {
		return inicioExpediente;
	}
	
	public String getDia() {
		return dia;
	}
	
	public void setDia(String dia) {
		this.dia = dia;
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
