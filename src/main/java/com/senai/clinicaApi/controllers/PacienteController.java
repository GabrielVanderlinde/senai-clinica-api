package com.senai.clinicaApi.controllers;

import com.senai.clinicaApi.dtos.PacienteDto;
import com.senai.clinicaApi.entites.PacienteEntity;
import com.senai.clinicaApi.services.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    //Injeção de Dependências
    private PacienteService service;

    public PacienteController(PacienteService service) {
    }

    //Methods
    @PostMapping("/paciente")
    public ResponseEntity<Boolean> cadastrarPaciente(@RequestBody PacienteDto pacienteDto) {
        Boolean resposta = service.inserirPaciente(pacienteDto);

        if (!resposta) {
            return ResponseEntity.badRequest().body(resposta);
        }

        return ResponseEntity.ok().body(resposta);
    }

    @GetMapping("/pacientes")
    public ResponseEntity<List<PacienteDto>> listarPacientes() {
        List<PacienteDto> pacientes = service.obterPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("paciente/{email}")
    public ResponseEntity<String> obterPacientePorEmail(@PathVariable String email) {
        PacienteEntity paciente = service.obterPaciente(email);

        if (paciente == null) {
            return ResponseEntity.status(400).body("Paciente com email :" + email + " não encontrado.");
        }
        return null;
    }

    @PutMapping("/paciente/{email}")
    public ResponseEntity<Boolean> atualizarPaciente(@PathVariable String email, @RequestBody PacienteDto pacienteDto) {
        Boolean resposta = service.atualizarPaciente(email, pacienteDto);

        if (!resposta) {
            return ResponseEntity.badRequest().body(resposta);
        }
        return ResponseEntity.ok().body(resposta);
    }

    //Delete pendente (aguardando Gustavo)
}
