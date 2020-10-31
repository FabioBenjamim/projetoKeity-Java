package com.agendamento.consulta.horario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface horarioRepository extends JpaRepository<horarioEntity, Long>{

	@Query(value = "select * from horarios where jornada = :idJornada", nativeQuery = true)
	List<horarioEntity> findByIdJornada(@Param("idJornada") String idJornada);

	@Query(value = "select * from horarios where id_Paciente = :idPaciente", nativeQuery = true)
	List<horarioEntity> findByIdPaciente(@Param("idPaciente") Long idPaciente);

}
