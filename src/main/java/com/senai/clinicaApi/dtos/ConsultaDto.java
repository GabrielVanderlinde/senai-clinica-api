package com.senai.clinicaApi.dtos;

import com.senai.clinicaApi.entities.PacienteEntity;
import com.senai.clinicaApi.entities.StatusConsulta;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.time.LocalDate;

public class ConsultaDto {

    private long id;

    @NotBlank
    private String titulo;

    @NotNull
    private LocalDate dataConsulta;

    @NotNull
    private StatusConsulta statusConsulta;

    @NotBlank
    @Email
    private String emailPaciente;

    public ConsultaDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public StatusConsulta getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(StatusConsulta statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }
}
