package com.agendamento.consulta.agenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JornadaDeTrabalhoService {
	
	@Autowired
	JornadaDeTrabalhoRepository _repository;
	
	public List<JornadaDeTrabalhoEntity> getJornadaDeTrabalho() {
		return _repository.findAll();
	}

	public ResponseEntity createJornadaDeTrabalho(JornadaDeTrabalhoEntity jornadaDeTrabalho) {
		try {
			_repository.save(jornadaDeTrabalho);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public void salva(JornadaDeTrabalhoEntity jornada) {
		_repository.save(jornada);
	}
}
