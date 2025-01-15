package med.voll.api.models.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.models.Consulta;

public interface IConsultaRepository extends JpaRepository<Consulta, Long> {

} 
