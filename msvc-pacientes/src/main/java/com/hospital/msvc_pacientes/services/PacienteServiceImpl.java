package com.hospital.msvc_pacientes.services;

import com.hospital.msvc_pacientes.exceptions.PacienteException;
import com.hospital.msvc_pacientes.models.Paciente;
import com.hospital.msvc_pacientes.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Paciente> findAll() {
        return this.pacienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente findById(Long id) {
        return this.pacienteRepository.findById(id).orElseThrow(
                () -> new PacienteException("Paciente con id: " + id + " no encontrado")
        );
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente findByRun(String run) {
        return this.pacienteRepository.findByRun(run).orElseThrow(
                () -> new PacienteException("Paciente con run: " + run + " no encontrado")
        );
    }

    @Transactional
    @Override
    public Paciente save(Paciente paciente) {
        if (this.pacienteRepository.findByRun(paciente.getRun()).isPresent()) {
            throw new PacienteException("Paciente con run: " + paciente.getRun() + " ya existente");
        }
        return this.pacienteRepository.save(paciente);
    }

    @Transactional
    @Override
    public Paciente updateById(Long id, Paciente paciente) {
        return this.pacienteRepository.findById(id).map(element -> {
            element.setNombreCompleto(paciente.getNombreCompleto());
            element.setTipoSangre(paciente.getTipoSangre());
            return this.pacienteRepository.save(element);
        }).orElseThrow(
                () -> new PacienteException("Paciente con id: " + id + " no encontrado")
        );
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        this.pacienteRepository.findById(id).orElseThrow(
                () -> new PacienteException("Paciente con id: " + id + " no encontrado")
        );
        this.pacienteRepository.deleteById(id);
    }
}
