package med.voll.api.models.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.models.Paciente;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
}
