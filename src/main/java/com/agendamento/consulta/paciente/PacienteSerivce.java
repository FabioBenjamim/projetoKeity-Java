package com.agendamento.consulta.paciente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpInc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PacienteSerivce {
	
	@Autowired
	PacienteRepository _repository;

	public List<PacienteEntity> getPacientes() {
		return _repository.findAll();
	}
	
	public ResponseEntity createPaciente(PacienteEntity paciente) {
		try {
			_repository.save(paciente);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}