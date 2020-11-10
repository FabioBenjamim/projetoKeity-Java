package com.agendamento.consulta.lastLogin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LastLoginRepository extends JpaRepository<LastLogin, Long>{

	@Query(value = "select * from last_login where medicos = :idMedico", nativeQuery = true)
	List<LastLogin> findByMedico(@Param(value = "idMedico") Long idMedico);

}
