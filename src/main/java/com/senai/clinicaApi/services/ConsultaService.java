package com.senai.clinicaApi.services;

import com.senai.clinicaApi.dtos.ConsultaDto;
import com.senai.clinicaApi.entities.ConsultaEntity;
import com.senai.clinicaApi.entities.PacienteEntity;
import com.senai.clinicaApi.repositories.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;

    public ConsultaService(ConsultaRepository consultaRepository, PacienteRepository pacienteRepository) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public List<ConsultaDto> obterConsulta(){

        List<ConsultaEntity> listaConsulta = consultaRepository.findAll();

        List<ConsultaDto> listaDto = new ArrayList<>();

        for(ConsultaEntity entity : listaConsulta){
            ConsultaDto consulta = new ConsultaDto();

            consulta.setId(entity.getId());
            consulta.setTitulo(entity.getTitulo());
            consulta.setDataConsulta(entity.getDataConsulta());
            consulta.setStatusConsulta(entity.getStatusConsulta());
            consulta.setEmailPaciente(entity.getPaciente().getEmail());

            listaDto.add(consulta);
        }
        return listaDto;
    }

    //inserir
    public boolean inserirConsulta(ConsultaDto consultaDto){

        //verifica se existe paciente pelo email
        PacienteEntity paciente = pacienteRepository
                .findByEmail(consultaDto.getEmailPaciente())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Paciente não encontrado"
                ));


        //verifica se consulta ja ta marcada no mesmo dia
        if (consultaRepository.existsByPacienteAndDataConsulta(
                paciente, consultaDto.getDataConsulta())) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Já existe consulta nessa data"
            );
        }

        ConsultaEntity consultaEntity = new ConsultaEntity();

        consultaEntity.setTitulo(consultaDto.getTitulo());
        consultaEntity.setDataConsulta(consultaDto.getDataConsulta());
        consultaEntity.setStatusConsulta(consultaDto.getStatusConsulta());
        consultaEntity.setPaciente(paciente);

        consultaRepository.save(consultaEntity);

        return true;
    }

    public boolean atualizarConsulta(long id, ConsultaDto dto){

        ConsultaEntity consulta = consultaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Consulta não encontrada"
                ));


        PacienteEntity paciente = pacienteRepository
                .findByEmail(dto.getEmailPaciente())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Paciente não encontrado"
                ));

        if (consultaRepository.existsByPacienteAndDataConsultaAndIdNot(paciente, dto.getDataConsulta(), id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe consulta nessa data");
        }

        consulta.setTitulo(dto.getTitulo());
        consulta.setDataConsulta(dto.getDataConsulta());
        consulta.setStatusConsulta(dto.getStatusConsulta());
        consulta.setPaciente(paciente);

        consultaRepository.save(consulta);

        return true;
    }

    public boolean excluirConsulta(long id){
        consultaRepository.deleteById(id);
        return true;
    }

}
