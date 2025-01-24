package med.voll.api.controller;

import med.voll.api.dtos.consultas.ConsultaDto;
import med.voll.api.models.interfaces.IConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
        return ResponseEntity.ok(consultas);
    }
}