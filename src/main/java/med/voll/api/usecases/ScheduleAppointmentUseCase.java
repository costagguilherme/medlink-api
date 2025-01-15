package med.voll.api.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import med.voll.api.dtos.consultas.ConsultaDto;
import med.voll.api.models.Consulta;
import med.voll.api.models.Medico;
import med.voll.api.models.interfaces.IConsultaRepository;
import med.voll.api.models.interfaces.IMedicoRepository;
import med.voll.api.models.interfaces.IPacienteRepository;

@Service
public class ScheduleAppointmentUseCase {

    @Autowired
    private IConsultaRepository consultaRepository;

    
    @Autowired
    private IMedicoRepository medicoRepository;

    @Autowired
    private IPacienteRepository pacienteRepository;

    public Consulta execute(ConsultaDto data) {
        var medico = this.medicoRepository.findById(data.medicoId())
                    .orElseThrow(() -> new RuntimeException("Médico não existe"));
        if (medico == null) {
            throw new RuntimeException("Médico não existe");
        }
       
        var paciente = this.pacienteRepository.findById(data.pacienteId())
                    .orElseThrow(() -> new RuntimeException("Paciente não existe"));

        var consulta = new Consulta(null, medico, paciente, data.data());
        var result = this.consultaRepository.save(consulta);
        return result;
    }

}