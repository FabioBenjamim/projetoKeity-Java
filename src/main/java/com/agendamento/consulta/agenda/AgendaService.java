package com.agendamento.consulta.agenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {

	@Autowired
	AgendaRepository _repository;

	public List<AgendaEntity> getAgendas() {
		return _repository.findAll();
	}

	public ResponseEntity createAgendas(AgendaEntity agenda) {
		try {
			_repository.save(agenda);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
