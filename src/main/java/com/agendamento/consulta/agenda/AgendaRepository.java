package com.agendamento.consulta.agenda;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long>{

}