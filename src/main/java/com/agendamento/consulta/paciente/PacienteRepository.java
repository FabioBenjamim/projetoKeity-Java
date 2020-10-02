package com.agendamento.consulta.paciente;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

}
