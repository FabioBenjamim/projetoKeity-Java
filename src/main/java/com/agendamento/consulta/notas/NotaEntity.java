package com.agendamento.consulta.notas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NOTA")
public class NotaEntity {
	
		public NotaEntity() {
			// TODO Auto-generated constructor stub
		}
		
		public NotaEntity(Integer nota) {
			this.nota = nota;
		}

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idNota;
		
		private Integer nota;
		
		public Long getIdNota() {
			return idNota;
		}
		
		public void setIdNota(Long idNota) {
			this.idNota = idNota;
		}
		
		public Integer getNota() {
			return nota;
		}
		
		public void setNota(Integer nota) {
			this.nota = nota;
		}

}
