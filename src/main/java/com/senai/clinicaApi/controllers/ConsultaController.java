package com.senai.clinicaApi.controllers;

import com.senai.clinicaApi.dtos.ConsultaDto;
import com.senai.clinicaApi.dtos.PacienteDto;
import com.senai.clinicaApi.entities.PacienteEntity;
import com.senai.clinicaApi.repositories.ConsultaRepository;
import com.senai.clinicaApi.services.ConsultaService;
import com.senai.clinicaApi.services.PacienteService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class ConsultaController {
    private ConsultaService service;

    public ConsultaController(ConsultaService service){
        this.service = service;
    }

    @GetMapping("/consultas")
    public ResponseEntity<List<ConsultaDto>> listarConsultas() {
        List<ConsultaDto> consultas = service.obterConsulta();
        if (consultas.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(consultas);
    }

    @PostMapping("/consulta")
    public ResponseEntity<String> cadastrarConsulta(@RequestBody ConsultaDto consultaDto) {

        service.inserirConsulta(consultaDto);

        return ResponseEntity.ok().body("Consulta marcada com sucesso!");

    }

    @PutMapping("/consultas/{id}")
    public ResponseEntity<String> atualizarConsulta(@PathVariable long id, @RequestBody ConsultaDto consultaDto){
        service.atualizarConsulta(id,consultaDto);

        return ResponseEntity.ok().body("Consulta atualizada com sucesso");
    }

    @DeleteMapping("/consulta/{id}")
    public ResponseEntity<String> deletarConsulta(@PathVariable long id){
        service.excluirConsulta(id);

        return ResponseEntity.ok().body("Consulta cancelada com sucesso!");
    }
}
