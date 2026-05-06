package com.senai.clinicaApi.controllers;

import com.senai.clinicaApi.dtos.PacienteDto;
import com.senai.clinicaApi.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    //Injeção de Dependências
    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    //Methods
    @PostMapping
    public ResponseEntity<Object> cadastrarPaciente(@RequestBody @Valid PacienteDto pacienteDto) {
        boolean resposta = service.inserirPaciente(pacienteDto);
        if (!resposta) return ResponseEntity.status(409).body("Já existe paciente");
        return ResponseEntity.ok().body("Paciente inserido com sucesso!");
    }

    @GetMapping()
    public ResponseEntity<Object> listarPacientes() {
        List<PacienteDto> pacientes = service.obterPacientes();
        if (pacientes.isEmpty()) return ResponseEntity.status(404).body("Lista vazia de pacientes");
        return ResponseEntity.ok(pacientes);
    }


    @PutMapping("/{email}")
    public ResponseEntity<Object> atualizarPaciente(@PathVariable @Valid String email, @RequestBody PacienteDto pacienteDto) {
        boolean resposta = service.atualizarPaciente(email, pacienteDto);
        if (!resposta) return ResponseEntity.status(404).body("Paciente não encontrado.");
        return ResponseEntity.ok().body("Paciente atualizado com sucesso!");
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Object> excluirPaciente(@PathVariable String email) {

        if (service.obterPaciente(email) == null) return ResponseEntity.status(404).body("Paciente não existe");
        boolean resposta = service.excluirPaciente(email);

        if (!resposta) return ResponseEntity.status(409).body("Paciente vinculado em consultas");
        return ResponseEntity.ok("Paciente excluído com sucesso");

    }
}
