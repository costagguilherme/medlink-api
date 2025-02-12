package med.voll.api.dtos.medicos;

import med.voll.api.enums.EspecialidadeEnum;

public record MedicoGetResponseDto(Long id, String nome, String email, String crm, Boolean ativo, EspecialidadeEnum especialidade) {
}
