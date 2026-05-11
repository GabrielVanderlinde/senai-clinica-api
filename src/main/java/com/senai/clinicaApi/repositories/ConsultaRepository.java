package com.senai.clinicaApi.repositories;

import com.senai.clinicaApi.entities.ConsultaEntity;
import com.senai.clinicaApi.entities.PacienteEntity;
import com.senai.clinicaApi.entities.StatusConsulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long> {

    Optional<ConsultaEntity> findByPacienteAndDataConsulta(PacienteEntity paciente, LocalDate dataConsulta);

    boolean existsByPacienteAndDataConsultaAndIdNot(PacienteEntity paciente, LocalDate dataConsulta, long id);

    boolean existsByPacienteAndDataConsulta(PacienteEntity paciente, LocalDate dataConsulta);

    boolean existsByPaciente(PacienteEntity paciente);

    List<ConsultaEntity> findByStatusConsulta(StatusConsulta statusConsulta);
}