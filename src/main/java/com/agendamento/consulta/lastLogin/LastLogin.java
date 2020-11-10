package com.agendamento.consulta.lastLogin;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.agendamento.consulta.agenda.JornadaDeTrabalhoEntity;
import com.agendamento.consulta.consultorio.ConsultorioEntity;
import com.agendamento.consulta.medico.MedicoEntity;

@Entity
@Table(name = "LAST_LOGIN")
public class LastLogin {
	
	public LastLogin() {
		// TODO Auto-generated constructor stub
	}
	
	public LastLogin(MedicoEntity medico) {
		this.data = new Date();
		this.medico = medico;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLastLogin;

	@Column
	private Date data;

	@ManyToOne
	@JoinColumn(name = "MEDICOS")
	private MedicoEntity medico;
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Long getIdLastLogin() {
		return idLastLogin;
	}
	
	public void setIdLastLogin(Long idLastLogin) {
		this.idLastLogin = idLastLogin;
	}
	
	public void setMedico(MedicoEntity medico) {
		this.medico = medico;
	}

}
