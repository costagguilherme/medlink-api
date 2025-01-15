package med.voll.api.dtos.consultas;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.enums.EspecialidadeEnum;

public record ConsultaDto(
        @NotNull
        Long medicoId,

        @NotNull
        Long pacienteId,

        @NotNull
        @Future
        LocalDateTime data,

        EspecialidadeEnum especialidade) {
}