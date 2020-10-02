package com.agendamento.consulta.medico;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Long>{

}
