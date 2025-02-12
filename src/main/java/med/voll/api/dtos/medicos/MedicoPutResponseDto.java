package med.voll.api.dtos.medicos;

import med.voll.api.enums.EspecialidadeEnum;

public record MedicoPutResponseDto(
    Long id,
    String nome,
    String email,
    String telefone,
    String crm,
    EspecialidadeEnum especialidade
    // EnderecoDto endereco
) {
}
