package com.agendamento.consulta.consultorio;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.agendamento.consulta.medico.MedicoEntity;

	@Entity
	@Table(name = "CONSULTORIOS" )
	public class ConsultorioEntity {
		
		@Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	    @Column(name = "idConsultorio", nullable = false, length = 255, insertable = true, updatable = true)
	    private UUID idConsultorio;
		
		@Column
		private String endereco;
		
		@Column
		private int numero;
		
		@Column
		private String pontoReferencia;
		
		@ManyToMany(cascade = CascadeType.ALL)
		  @JoinTable(name="CONSULTORIO_MEDICO",
		             joinColumns={@JoinColumn(name="idConsultorio")},
		             inverseJoinColumns={@JoinColumn(name="idMedico")})
		public List<MedicoEntity> medicos;

		public UUID getIdConsultorio() {
			return idConsultorio;
		}

		public void setIdConsultorio(UUID idConsultorio) {
			this.idConsultorio = idConsultorio;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public String getPontoReferencia() {
			return pontoReferencia;
		}

		public void setPontoReferencia(String pontoReferencia) {
			this.pontoReferencia = pontoReferencia;
		}
		
		
}
