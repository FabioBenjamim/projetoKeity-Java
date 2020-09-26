package com.agendamento.consulta.paciente.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.consulta.paciente.PacienteEntity;
import com.agendamento.consulta.paciente.PacienteSerivce;

@RestController
@RequestMapping("/pacientes")
public class PacienteRest {
	
	@Autowired
	PacienteSerivce _service;

	@GetMapping
	public List<PacienteEntity> getPacientes() {
		return _service.getPacientes();
	}
	
	@PostMapping
	public ResponseEntity createPaciente(@RequestBody PacienteEntity paciente) {
		return _service.createPaciente(paciente);
	}
	
}
