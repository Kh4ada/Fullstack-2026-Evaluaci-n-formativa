package com.hospital.msvc_pacientes.controllers;

import com.hospital.msvc_pacientes.models.Paciente;
import com.hospital.msvc_pacientes.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
@Validated
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll() {
        return ResponseEntity.ok(this.pacienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.pacienteService.findById(id));
    }

    @GetMapping("/run/{run}")
    public ResponseEntity<Paciente> findByRun(@PathVariable String run) {
        return ResponseEntity.ok(this.pacienteService.findByRun(run));
    }

    @PostMapping
    public ResponseEntity<Paciente> save(@Valid @RequestBody Paciente paciente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pacienteService.save(paciente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updateById(@PathVariable Long id, @Valid @RequestBody Paciente paciente) {
        return ResponseEntity.ok(this.pacienteService.updateById(id, paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.pacienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
