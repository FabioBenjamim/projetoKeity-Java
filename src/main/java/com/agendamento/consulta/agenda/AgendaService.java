package com.agendamento.consulta.agenda;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.agendamento.consulta.consultorio.ConsultorioEntity;

@Service
public class AgendaService {

	@Autowired
	AgendaRepository _repository;
	
	@Autowired
	JornadaDeTrabalhoService _serviceJornada;

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

	public ResponseEntity atualizaAgenda(AgendaEntity agenda) {
		try {
			if (agenda.getIdAgenda() != null) {
				Optional<AgendaEntity> uptadeConsultorio = _repository.findById(agenda.getIdAgenda());
				_serviceJornada.salva(agenda.getSemana());
				uptadeConsultorio.get().getSemana().addAll(agenda.getSemana());
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
