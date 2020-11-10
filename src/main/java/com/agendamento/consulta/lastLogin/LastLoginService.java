package com.agendamento.consulta.lastLogin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendamento.consulta.medico.MedicoEntity;

@Service
public class LastLoginService {
	
	@Autowired
	LastLoginRepository _repository;
	
	public void saveLastLoginMedico(MedicoEntity medico) {
		LastLogin lastLoginMedico = new LastLogin(medico);
		_repository.save(lastLoginMedico);
	}

	public List<LastLogin> getLastLoginMedico(Long idMedico) {
		return _repository.findByMedico(idMedico);
	}

}
