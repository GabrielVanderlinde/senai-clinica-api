package com.senai.clinicaApi.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class PacienteDto {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    //Constructor
    public PacienteDto() {
    }

    //Get and Sett
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
