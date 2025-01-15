package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dtos.consultas.ConsultaDto;
import med.voll.api.usecases.ScheduleAppointmentUseCase;


@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ScheduleAppointmentUseCase scheduleAppointmentUseCase;

    @PostMapping
    @Transactional
    public ResponseEntity schedule(@RequestBody @Valid ConsultaDto data) {
        var consulta = this.scheduleAppointmentUseCase.execute(data);
        return ResponseEntity.ok(consulta);
    }

}