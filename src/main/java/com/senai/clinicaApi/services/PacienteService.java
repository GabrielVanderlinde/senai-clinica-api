package com.senai.clinicaApi.services;

import com.senai.clinicaApi.dtos.PacienteDto;
import com.senai.clinicaApi.entities.PacienteEntity;
import com.senai.clinicaApi.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    //Constructor
    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    //Lista de Pacientes
    List<PacienteEntity> pacientes = new ArrayList<PacienteEntity>();

    public List<PacienteDto> obterPacientes() {
        List<PacienteEntity> pacientes = repository.findAll();
        List<PacienteDto> pacientesDto = new ArrayList<>();

        for (PacienteEntity paciente : pacientes) {
            PacienteDto dto = new PacienteDto();
            dto.setNome(paciente.getNome());
            dto.setEmail(paciente.getEmail());
            pacientesDto.add(dto);
        }

        return pacientesDto;

    }

    public boolean inserirPaciente(PacienteDto pacienteDto) {

        if (repository.existsByEmail(pacienteDto.getEmail())) {
            return false;
        }

        PacienteEntity paciente = new PacienteEntity();
        paciente.setNome(pacienteDto.getNome());
        paciente.setEmail(paciente.getEmail());
        repository.save(paciente);
        return true;
    }

    public boolean atualizarPaciente(String email, PacienteDto pacienteDto) {
        Optional<PacienteEntity> optional = repository.findByEmail(email);

        if (optional.isEmpty()) {
            return false;
        }

        PacienteEntity paciente = optional.get();
        paciente.setNome(pacienteDto.getNome());
        paciente.setEmail(paciente.getEmail());
        repository.save(paciente);

        return true;
    }

    public PacienteEntity obterPaciente(String email) {
        Optional<PacienteEntity> optional = repository.findByEmail(email);
        return optional.orElse(null);
    }

    public boolean excluirPaciente(String email) {
        Optional<PacienteEntity> optional = repository.findByEmail(email);

        if (optional.isEmpty()) {
            return false;
        }

        repository.delete(optional.get());
        return true;
    }

}
