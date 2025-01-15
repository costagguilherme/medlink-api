package med.voll.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dtos.pacientes.PacienteDto;
import med.voll.api.dtos.pacientes.PacientePutDto;


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

    public Paciente(PacienteDto data) {
        this.nome = data.nome();
        this.cpf = data.cpf();
    }

    public void update(PacientePutDto data) {
        this.nome = data.nome() != null ? data.nome() : this.nome;
        this.cpf = data.cpf() != null ? data.cpf() : this.cpf;
    }

  
}
