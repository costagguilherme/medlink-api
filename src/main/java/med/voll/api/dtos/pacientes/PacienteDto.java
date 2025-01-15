package med.voll.api.dtos.pacientes;


import jakarta.validation.constraints.NotBlank;

public record PacienteDto (
    @NotBlank
    String nome,

    @NotBlank
    String cpf

) {}
