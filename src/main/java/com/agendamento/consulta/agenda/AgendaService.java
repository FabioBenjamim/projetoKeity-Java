package com.agendamento.consulta.agenda;

import java.util.List;
import java.util.Optional;

import org.hibernate.result.UpdateCountOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.agendamento.consulta.agenda.api.dto.AgendaDTO;

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

	public ResponseEntity atualizaAgenda(AgendaDTO agenda) {
		try {
			if (agenda.getIdAgenda() != null) {
				Optional<AgendaEntity> uptadeConsultorio = _repository.findById(agenda.getIdAgenda());
				JornadaDeTrabalhoEntity jornada = new JornadaDeTrabalhoEntity(agenda.getSemana().getDiaDaSemana(),
						agenda.getSemana().getInicioExpediente(), agenda.getSemana().getFimExpediente());
				_serviceJornada.salva(jornada);
				uptadeConsultorio.get().getSemana().add(jornada);
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
