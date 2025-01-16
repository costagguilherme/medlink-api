package med.voll.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dtos.pacientes.PacienteDto;
import med.voll.api.dtos.pacientes.PacientePutDto;
import med.voll.api.models.Paciente;
import med.voll.api.models.interfaces.IPacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController extends BaseController {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @PostMapping
    public ResponseEntity<Paciente> create(@RequestBody @Valid PacienteDto data) {
        Paciente paciente = new Paciente(data);
        Paciente savedPaciente = this.pacienteRepository.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPaciente);
    }


    @GetMapping
    public ResponseEntity<Page<Paciente>> get(@PageableDefault(size = 10) Pageable pagination) {
        Page<Paciente> pacientes = this.pacienteRepository.findAll(pagination);
        return ResponseEntity.ok(pacientes);
    }


    @GetMapping("/{id}") 
    ResponseEntity<Paciente> getById(@PathVariable Long id) {
        Paciente paciente = this.pacienteRepository.findById(id).orElse(null);
        if (paciente == null) {
            return (ResponseEntity<Paciente>) this.errorResponse(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }

        return ResponseEntity.ok(paciente);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Paciente> update(@RequestBody @Valid PacientePutDto data, @PathVariable Long id) {
        Paciente paciente = this.pacienteRepository.findById(id).orElse(null);
        if (paciente == null) {
            return (ResponseEntity<Paciente>) this.errorResponse(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }
        paciente.update(data);
        return ResponseEntity.ok(paciente);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Paciente> delete(@PathVariable Long id) {
        Paciente paciente = this.pacienteRepository.findById(id).orElse(null);
        if (paciente == null) {
            return (ResponseEntity<Paciente>) this.errorResponse(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }

        this.pacienteRepository.deleteById(id);
        return ResponseEntity.ok(paciente);
    }


    
    

}
