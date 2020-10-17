package com.agendamento.consulta.medico;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendamento.consulta.paciente.PacienteEntity;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Long>{
	
	Optional<MedicoEntity> findByCpf(String cpf);
	
	Optional<MedicoEntity> findById(Long idMedico);
	
}
