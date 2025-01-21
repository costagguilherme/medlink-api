package med.voll.api.dtos.pacientes;

import java.util.Date;

public record PacientePutDto (
    String nome,
    String cpf,
    String telefone,
    Date dataNascimento,
    String genero,
    String email
) {}
