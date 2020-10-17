package com.agendamento.consulta.paciente.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.consulta.paciente.PacienteEntity;
import com.agendamento.consulta.paciente.PacienteRepository;
import com.agendamento.consulta.paciente.PacienteSerivce;

@RestController
@RequestMapping("/pacientes")
public class PacienteRest {
	
	@Autowired
	PacienteSerivce _service;
	
	@Autowired
    private PacienteRepository pacientes;

	@GetMapping
	public List<PacienteEntity> getPacientes() {
		return _service.getPacientes();
	}
	
	@PostMapping
	public ResponseEntity createPaciente(@RequestBody PacienteEntity paciente) {
		return _service.createPaciente(paciente);
	}
	
	@PostMapping("/{Autentica}")
    public ResponseEntity<Boolean> Login(@RequestBody PacienteEntity pacienteRequest) {
        Optional<PacienteEntity> paciente = pacientes.findByCpf(pacienteRequest.getCpf());
        if (paciente != null && paciente.get().getSenha().equals(pacienteRequest.getSenha())) {
            return ResponseEntity.ok(true);
        } else {
            return (ResponseEntity<Boolean>) ResponseEntity.badRequest();
        }
    }
	
	@PutMapping("/trocaSenha")
    public ResponseEntity atualizarPaciente(@RequestBody PacienteEntity paciente) {
        if (paciente.getIdPaciente() != null) {
            Optional<PacienteEntity> pacienteChange = pacientes.findById(paciente.getIdPaciente());
            pacienteChange.get().atualizarPaciente(paciente);
            pacientes.save(pacienteChange.get());
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }
	
}
