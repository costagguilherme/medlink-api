package med.voll.api.dtos.medicos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.dtos.EnderecoDto;
import med.voll.api.enums.EspecialidadeEnum;

public record MedicoDto (
    @NotBlank
    String nome,

    @NotBlank
    @Email
    String email,

    @NotBlank
    String telefone,

    @NotBlank
    @Pattern(regexp= "\\d{4,6}")
    String crm,

    @NotNull
    EspecialidadeEnum especialidade,

    @NotNull
    @Valid
    EnderecoDto endereco
) {}
