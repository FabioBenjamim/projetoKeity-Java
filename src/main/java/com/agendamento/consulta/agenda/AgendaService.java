package com.agendamento.consulta.agenda;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.hibernate.result.UpdateCountOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.agendamento.consulta.agenda.api.dto.AgendaDTO;
import com.agendamento.consulta.horario.horarioEntity;
import com.agendamento.consulta.horario.horarioService;

@Service
public class AgendaService {

	@Autowired
	AgendaRepository _repository;

	@Autowired
	JornadaDeTrabalhoService _serviceJornada;
	
	@Autowired
	horarioService _serviceHorario;
	
	private Long idMedico;

	public List<AgendaEntity> getAgendas() {
		return _repository.findAll();
	}

	public ResponseEntity createAgendas(AgendaEntity agenda) {
		try {
			_repository.save(agenda);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity atualizaAgenda(AgendaDTO agenda, String nomePaciente) {
		try {
			if (agenda.getIdAgenda() != null) {
				Optional<AgendaEntity> agendaUpdate = _repository.findById(agenda.getIdAgenda());
				JornadaDeTrabalhoEntity jornada = new JornadaDeTrabalhoEntity(agenda.getSemana().getDiaDaSemana(),
						agenda.getSemana().getInicioExpediente(), agenda.getSemana().getFimExpediente());
				_serviceJornada.salva(jornada);
				agendaUpdate.get().getSemana().add(jornada);

				String[] inicioAux = jornada.getInicioExpediente().split(":");
				String[] fimAux = jornada.getFimExpediente().split(":");

				Integer inicioHora = Integer.parseInt(inicioAux[0]);
				Integer fimHora = Integer.parseInt(fimAux[0]);

				Integer inicioMinutos = Integer.parseInt(inicioAux[1]);
				Integer fimMinutos = Integer.parseInt(fimAux[1]);

				Integer cargaHora = fimHora - inicioHora;
				cargaHora = cargaHora * 60;
				Integer cargaHorariaMinutos = cargaHora + inicioMinutos;
				cargaHorariaMinutos = cargaHorariaMinutos + fimMinutos;

				SimpleDateFormat horarioLivre = new SimpleDateFormat("HH:mm");
				Calendar cal = Calendar.getInstance();

				System.out.println(fimMinutos + "LS");
				List<String> agendaHorario = new ArrayList<String>();
				Integer cargaHorariaMinutosAux = 0;
				Integer countAux = 0;
				while (cargaHorariaMinutos >= 15) {
					System.out.println(cargaHorariaMinutos);
					cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(inicioAux[0]));
					cal.set(Calendar.MINUTE, Integer.parseInt(inicioAux[1] + cargaHorariaMinutosAux));
					agendaHorario.add(horarioLivre.format(cal.getTime()));
					if (countAux != 0) {
						cargaHorariaMinutos -= 15;
					}
					cargaHorariaMinutosAux += 15;
					countAux++;
				}
				idMedico = agenda.getIdMedico();
				List<horarioEntity> AgendaHorarios = new ArrayList<horarioEntity>();
				agendaHorario.stream().forEach(c -> AgendaHorarios.add(new horarioEntity(jornada, c, nomePaciente, idMedico)));				
				
				_repository.save(agendaUpdate.get());
				_serviceHorario.createHorarios(AgendaHorarios);

				return new ResponseEntity(HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
