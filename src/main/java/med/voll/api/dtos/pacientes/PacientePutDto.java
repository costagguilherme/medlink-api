package med.voll.api.dtos.pacientes;


import jakarta.validation.constraints.NotBlank;

public record PacientePutDto (
    String nome,
    String cpf
) {}
