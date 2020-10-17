package com.agendamento.consulta.paciente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendamento.consulta.medico.MedicoEntity;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {
	
	Optional<PacienteEntity> findByCpf(String cpf);
	Optional<PacienteEntity> findById(Long idPaciente);
}
