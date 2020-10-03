package com.agendamento.consulta.agenda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.consulta.agenda.JornadaDeTrabalhoEntity;
import com.agendamento.consulta.agenda.JornadaDeTrabalhoService;

@RestController
@RequestMapping("/jornada")
public class JornadaDeTrabalhoRest {
	@Autowired
	JornadaDeTrabalhoService _service;
	
	@GetMapping
	public List<JornadaDeTrabalhoEntity> getJornadaDeTrabalho() {
		return _service.getJornadaDeTrabalho();
	}
	
	@PostMapping
	public void createJornadaDeTrabalho(@RequestBody JornadaDeTrabalhoEntity jornadaDeTrabalho) {
	 //_service.createJornadaDeTrabalho(jornadaDeTrabalho);
	}
}
