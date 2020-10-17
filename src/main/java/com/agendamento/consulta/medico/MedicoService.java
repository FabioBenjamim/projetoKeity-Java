package com.agendamento.consulta.medico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

	@Autowired
	MedicoRepository _repository;

	public Optional<MedicoEntity> getMedicos(Long idMedico) {
		if(idMedico != null) {
			return _repository.findById(idMedico);
		}
		return null;
	}

	public Optional<MedicoEntity> getMedico(String cpf) {
		return _repository.findByCpf(cpf);
	}
	
	public Optional<MedicoEntity> getMedico(Long idMedico) {
		return _repository.findById(idMedico);
	}

	public ResponseEntity createMedicos(MedicoEntity medico) {
		try {
			_repository.save(medico);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity adicionaConsultorios(MedicoEntity medico) {
		try {
			if (medico.getIdMedico() != null) {
				Optional<MedicoEntity> uptadeConsultorio = _repository.findById(medico.getIdMedico());
				uptadeConsultorio.get().getConsultorios().addAll(medico.getConsultorios());
				_repository.save(uptadeConsultorio.get());
				return new ResponseEntity(HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	public ResponseEntity adicionaMedico(ConsultorioEntity consultorio) {
//	try {
//		if (consultorio.getIdConsultorio() != null) {
//			Optional<ConsultorioEntity> uptadeConsultorio = _repository.findById(consultorio.getIdConsultorio());
//			uptadeConsultorio.get().getMedicos().addAll(consultorio.getMedicos());
//			_repository.save(uptadeConsultorio.get());
//			return new ResponseEntity(HttpStatus.OK);
//		} else {
//			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	} catch (Exception e) {
//		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//}
}
