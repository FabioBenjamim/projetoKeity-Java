package com.agendamento.consulta.consultorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConsultorioService {
	@Autowired
	ConsultorioRepository _repository;
	
	public List<ConsultorioEntity> getConsultorios(){
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
}
