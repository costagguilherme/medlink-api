package med.voll.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dtos.pacientes.PacienteDto;
import med.voll.api.dtos.pacientes.PacientePutDto;
import med.voll.api.enums.GeneroEnum;

import java.util.Date;


@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    private String email;

    public Paciente(PacienteDto data) {
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.telefone = data.telefone();
        this.dataNascimento = data.dataNascimento();
        this.genero = data.genero();
        this.email = data.email();
    }

    public void update(PacientePutDto data) {
        this.nome = data.nome() != null ? data.nome() : this.nome;
        this.cpf = data.cpf() != null ? data.cpf() : this.cpf;
        this.telefone = data.telefone() != null ? data.telefone() : this.telefone;
        this.dataNascimento = data.dataNascimento() != null ? data.dataNascimento() : this.dataNascimento;
        this.genero = data.genero() != null ? data.genero() : this.genero;
        this.email = data.email() != null ? data.email() : this.email;
    }

  
}
