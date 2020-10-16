package com.agendamento.consulta.horario;

import java.util.List;

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

}
