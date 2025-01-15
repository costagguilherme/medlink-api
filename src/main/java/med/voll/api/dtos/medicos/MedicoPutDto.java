package med.voll.api.dtos.medicos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.dtos.EnderecoDto;

public record MedicoPutDto(
    String nome,

    String telefone,

    @NotNull
    @Valid
    EnderecoDto endereco
) {
}
