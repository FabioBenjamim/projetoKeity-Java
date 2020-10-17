package com.agendamento.consulta.paciente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {
	
	Optional<PacienteEntity> findByCpf(String cpf);
}
