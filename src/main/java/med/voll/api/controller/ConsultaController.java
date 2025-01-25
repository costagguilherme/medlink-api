package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dtos.consultas.ConsultaDto;
import med.voll.api.models.interfaces.IConsultaRepository;
import med.voll.api.usecases.ScheduleAppointmentUseCase;


@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ScheduleAppointmentUseCase scheduleAppointmentUseCase;

    @Autowired
    private IConsultaRepository consultaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity schedule(@RequestBody @Valid ConsultaDto data) {
        var consulta = this.scheduleAppointmentUseCase.execute(data);
        return ResponseEntity.ok(consulta);
    }

    @GetMapping
    public ResponseEntity getAllConsultas() {
        var consultas = consultaRepository.findAll();

        var consultasCompletas = consultas.stream()
            .map(consulta -> new Object() {
                public final Long id = consulta.getId();
                public final String data = consulta.getData().toString();
                public final String medico = consulta.getMedico().getNome();
                public final String paciente = consulta.getPaciente().getNome();
            })
            .toList();
    
        return ResponseEntity.ok(consultasCompletas);
    }
}