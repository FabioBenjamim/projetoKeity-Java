package com.agendamento.consulta.medico.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.consulta.medico.MedicoEntity;
import com.agendamento.consulta.medico.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoRest {
	
	@Autowired
	MedicoService _service;
	
	@GetMapping
	public List<MedicoEntity> getMedicos() {
		return _service.getMedicos();
	}
	
	@PostMapping
	public ResponseEntity createMedico(@RequestBody MedicoEntity medico) {
		return _service.createMedicos(medico);
	}
	
	@PutMapping("/consultorios")
	public ResponseEntity adicionaConsultorios(@RequestBody MedicoEntity medico) {
		return _service.adicionaConsultorios(medico);
	}
	
}
