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

	public JornadaDeTrabalhoEntity(DiaDaSemanaEnum diaDaSemana, String inicioExpediente,
			String fimExpediente) throws ParseException {
		super();
		this.diaDaSemana = diaDaSemana;
		this.inicioExpediente = inicioExpediente;
		this.fimExpediente = fimExpediente;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idJornada;

	@Column
	private DiaDaSemanaEnum diaDaSemana;

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

	public DiaDaSemanaEnum getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(DiaDaSemanaEnum diaDaSemana) {
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
