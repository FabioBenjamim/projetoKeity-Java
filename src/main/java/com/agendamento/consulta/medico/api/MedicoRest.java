package com.agendamento.consulta.medico.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.consulta.medico.MedicoEntity;
import com.agendamento.consulta.medico.MedicoRepository;
import com.agendamento.consulta.medico.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoRest {
	
	@Autowired
	MedicoService _service;
	
<<<<<<< Updated upstream
	@GetMapping(value = {"/{idMedico}", ""})
	public Optional<MedicoEntity> getMedicos(@PathVariable Optional<Long> idMedico) {
		return _service.getMedicos(idMedico.get());
=======
	@Autowired
    private MedicoRepository medicos;
	
	@GetMapping
	public List<MedicoEntity> getMedicos() {
		return _service.getMedicos();
>>>>>>> Stashed changes
	}
	
	@PostMapping("/medico")
	public Optional<MedicoEntity> getMedico(@RequestParam Long idMedico){
		return _service.getMedico(idMedico);
	}
	
	@PostMapping
	public ResponseEntity createMedico(@RequestBody MedicoEntity medico) {
		return _service.createMedicos(medico);
	}
	
	@PutMapping("/consultorios")
	public ResponseEntity adicionaConsultorios(@RequestBody MedicoEntity medico) {
		return _service.adicionaConsultorios(medico);
	}
	
	@PostMapping("/{Autentica}")
    public ResponseEntity<Boolean> Login(@RequestBody MedicoEntity medicoRequest) {
        Optional<MedicoEntity> medico = medicos.findByCpf(medicoRequest.getCpf());
        if (medico != null && medico.get().getSenha().equals(medicoRequest.getSenha())) {
            return ResponseEntity.ok(true);
        } else {
            return (ResponseEntity<Boolean>) ResponseEntity.badRequest();
        }
    }
	
}
