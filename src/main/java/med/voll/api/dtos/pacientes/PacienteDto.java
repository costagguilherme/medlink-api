package med.voll.api.dtos.pacientes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

    @NotBlank
    String genero,

    @NotBlank
    String email

) {}
