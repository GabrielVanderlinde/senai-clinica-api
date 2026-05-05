package com.senai.clinicaApi.services;

import com.senai.clinicaApi.dtos.ConsultaDto;
import com.senai.clinicaApi.entities.ConsultaEntity;
import com.senai.clinicaApi.entities.PacienteEntity;
import com.senai.clinicaApi.repositories.*;
import org.springframework.stereotype.Service;

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

        //validacao, se existe um usuario com esse email

        Optional<PacienteEntity> paciente = pacienteRepository.findByEmail(consultaDto.getEmailPaciente());

        // 🔥 REGRA 10
        if (paciente.isEmpty()){
            return false;
        }

        PacienteEntity pacienteGet = paciente.get();


        List<PacienteEntity> listaPaciente = pacienteRepository.findAll();

        ConsultaEntity consultaEntity = new ConsultaEntity();

        consultaEntity.setId(consultaDto.getId());
        consultaEntity.setTitulo(consultaDto.getTitulo());
        consultaEntity.setDataConsulta(consultaDto.getDataConsulta());
        consultaEntity.setStatusConsulta(consultaDto.getStatusConsulta());

        consultaEntity.setPaciente(pacienteGet);
//        for (PacienteEntity paciente : listaPaciente){
//            if(paciente.getEmail().equals(consultaDto.getEmailPaciente())){
//                consultaEntity.setPaciente(paciente);
//            }
//        }

        consultaRepository.save(consultaEntity);

        return true;
    }

}
