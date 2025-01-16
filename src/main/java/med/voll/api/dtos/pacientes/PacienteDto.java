package med.voll.api.dtos.pacientes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.enums.GeneroEnum;

import java.util.Date;

public record PacienteDto (
    @NotBlank
    String nome,

    @NotBlank
    String cpf,

     @NotBlank
     String telefone,

    @NotNull
    Date dataNascimento,

    @NotNull
    GeneroEnum genero,

    @NotBlank
    String email

) {}
