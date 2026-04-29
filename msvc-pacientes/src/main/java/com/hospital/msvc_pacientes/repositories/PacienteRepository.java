package com.hospital.msvc_pacientes.repositories;

import com.hospital.msvc_pacientes.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByRun(String run);
}
