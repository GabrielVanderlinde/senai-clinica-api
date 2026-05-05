package com.senai.clinicaApi.repositories;

import com.senai.clinicaApi.entities.ConsultaEntity;
import com.senai.clinicaApi.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long> {

    Optional<ConsultaEntity> findByPacienteAndDataConsulta(PacienteEntity paciente, LocalDate dataConsulta);

    boolean existsByPacienteAndDataConsulta(PacienteEntity paciente, LocalDate dataConsulta);

    boolean existsByPaciente(PacienteEntity paciente);
}