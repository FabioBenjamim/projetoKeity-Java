package com.agendamento.consulta.horario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class horarioService {
	
	@Autowired
	horarioRepository _repository;
		
	public void createHorarios(List<horarioEntity> lista) {
		_repository.saveAll(lista);
	}

	public List<horarioEntity> getHorarios(String idJornada) {
		return _repository.findByIdJornada(idJornada);
	}

	public List<horarioEntity> atualizaHorario(Long idHorario, String nomePaciente, Long idPaciente) {
		Optional<horarioEntity> getHorario = _repository.findById(idHorario);
		getHorario.get().setNomePaciente(nomePaciente);
		getHorario.get().setStatus("OCUPADO");
		getHorario.get().setIdPaciente(idPaciente);
		_repository.save(getHorario.get());
		return null;
	}
	
	public List<horarioEntity> atualizaHorarios(Long idHorario, String nomePaciente, Long idPaciente, String consultaStatus) {
		Optional<horarioEntity> getHorario = _repository.findById(idHorario);
		getHorario.get().setNomePaciente(nomePaciente);
		getHorario.get().setStatus("OCUPADO");
		getHorario.get().setIdPaciente(idPaciente);
		getHorario.get().setConsultaRealizada(consultaStatus);
		_repository.save(getHorario.get());
		return null;
	}

	public List<horarioEntity> getHorariosPacientes(Long idPaciente) {
		return _repository.findByIdPaciente(idPaciente);
	}

}
