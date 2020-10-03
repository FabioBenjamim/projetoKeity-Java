package com.agendamento.consulta.agenda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.consulta.agenda.AgendaEntity;
import com.agendamento.consulta.agenda.AgendaService;
import com.agendamento.consulta.consultorio.ConsultorioEntity;

@RestController
@RequestMapping("/agendas")
public class AgendaRest {
	
	@Autowired
	AgendaService _service;
	
	@GetMapping
	public List<AgendaEntity> getAgendas() {
		return _service.getAgendas();
	}
	
	@PostMapping
	public ResponseEntity createAgenda(@RequestBody AgendaEntity agenda) {
		return _service.createAgendas(agenda);
	}
}
