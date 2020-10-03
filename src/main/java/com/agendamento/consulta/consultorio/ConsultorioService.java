package com.agendamento.consulta.consultorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ConsultorioService {
	@Autowired
	ConsultorioRepository _repository;

	public List<ConsultorioEntity> getConsultorios() {
		return _repository.findAll();
	}

	public ResponseEntity createConsultorios(ConsultorioEntity consultorio) {
		try {
			_repository.save(consultorio);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity atualizateConsultorio(ConsultorioEntity consultorio) {
		try {
			if(consultorio.getIdConsultorio() != null) {
				Optional<ConsultorioEntity> uptadeConsultorio = _repository.findById(consultorio.getIdConsultorio());
				uptadeConsultorio.get().atualizar(consultorio);
				_repository.save(uptadeConsultorio.get());
			}
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity adicionaMedico(ConsultorioEntity consultorio) {
		try {
			if(consultorio.getIdConsultorio() != null) {
				Optional<ConsultorioEntity> uptadeConsultorio = _repository.findById(consultorio.getIdConsultorio());
				uptadeConsultorio.get().getMedicos().addAll(consultorio.getMedicos());
				_repository.save(uptadeConsultorio.get());
				return new ResponseEntity(HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
