package com.senai.clinicaApi.controllers;

import com.senai.clinicaApi.dtos.ConsultaDto;
import com.senai.clinicaApi.services.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @GetMapping("/consultas")
    public ResponseEntity<Object> listarConsultas() {
        List<ConsultaDto> consultas = service.obterConsulta();
        if (consultas.isEmpty()) return ResponseEntity.status(404).body("Lista Vazia de Consultas");
        return ResponseEntity.ok(consultas);
    }

    @PostMapping()
    public ResponseEntity<String> cadastrarConsulta(@RequestBody @Valid ConsultaDto consultaDto) {

        service.inserirConsulta(consultaDto);

        return ResponseEntity.ok().body("Consulta inserida com sucesso");

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarConsulta(@PathVariable @Valid long id, @RequestBody ConsultaDto consultaDto) {
        service.atualizarConsulta(id, consultaDto);

        return ResponseEntity.ok().body("Consulta atualizada com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarConsulta(@PathVariable long id) {
        boolean resposta = service.excluirConsulta(id);
        if (!resposta) return ResponseEntity.status(404).body("Consulta não encontrada!");
        return ResponseEntity.ok("Consulta excluída com sucesso");
    }

    @PostMapping("/cancelar/{id}")
    public ResponseEntity<String> cancelarConsulta(@PathVariable Long id){
        service.cancelarConsulta(id);

        return ResponseEntity.ok().body("Consulta Cancelada!");
    }
}
