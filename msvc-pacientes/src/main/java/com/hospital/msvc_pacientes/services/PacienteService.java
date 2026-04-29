package com.hospital.msvc_pacientes.services;

import com.hospital.msvc_pacientes.models.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> findAll();
    Paciente findById(Long id);
    Paciente findByRun(String run);
    Paciente save(Paciente paciente);
    Paciente updateById(Long id, Paciente paciente);
    void deleteById(Long id);

}
