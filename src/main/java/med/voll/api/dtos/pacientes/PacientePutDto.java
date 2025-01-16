package med.voll.api.dtos.pacientes;

import med.voll.api.enums.GeneroEnum;

import java.util.Date;

public record PacientePutDto (
    String nome,
    String cpf,
    String telefone,
    Date dataNascimento,
    GeneroEnum genero,
    String email
) {}
